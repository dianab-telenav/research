package com.telenav.research.jooq;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import com.telenav.research.generated.Tables;


/**
 *
 *
 * @author dianabalan
 */
public class ExportImport {

    private static Logger LOG = Logger.getLogger(ExportImport.class);

    public static void main(final String[] args) {

        final Configuration dbConfig = Configuration.INSTANCE;
        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            final org.jooq.Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.MYSQL)
                    .set(new Settings().withExecuteLogging(true));

            final DSLContext create = DSL.using(configuration);

            // export select result of all participants in csv form. can also be possible in XML, JSON, HTML, Text
            final Result<Record> participants = create.select().from(Tables.PARTICIPANT).fetch();

            final String participantsXml = participants.formatXML();
            final String participantsCsv = participants.formatCSV();
            final String participantsJson = participants.formatJSON();

            try (final Writer writer = new PrintWriter("participants_export.csv")) {
                writer.write(participantsCsv);
            } catch (final IOException e) {
                LOG.error(e);
            }

            try (final Writer writer = new PrintWriter("participants_export.json")) {
                writer.write(participantsJson);
            } catch (final IOException e) {
                LOG.error(e);
            }

            try (final Writer writer = new PrintWriter("participants_export.xml")) {
                writer.write(participantsXml);
            } catch (final IOException e) {
                LOG.error(e);
            }

            final File importFile = new File("topics.csv");

            // import from csv. specify transactional behaviour (commit after 2). can commit also each or all
            try {
                final InputStream inputStream = new FileInputStream(importFile);
                create.loadInto(Tables.TOPIC).loadCSV(inputStream).fields(Tables.TOPIC.NUME).execute();
            } catch (final IOException e) {
                LOG.error(e);
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
