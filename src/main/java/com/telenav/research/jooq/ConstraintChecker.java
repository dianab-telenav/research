package com.telenav.research.jooq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import com.telenav.research.generated.Tables;


/**
 *
 *
 * @author dianabalan
 */
public class ConstraintChecker {

    private static Logger LOG = Logger.getLogger(ConstraintChecker.class);


    public static void main(final String[] args) {
        final Configuration dbConfig = Configuration.INSTANCE;
        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            final org.jooq.Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.MYSQL)
                    .set(new Settings().withExecuteLogging(false));
            configuration.set(new DefaultExecuteListenerProvider(new ConstraintCheckerListener()));

            final DSLContext create = DSL.using(configuration);

            try {
                create.dropTable(Tables.PARTICIPANT).execute();
            } catch (final RuntimeException e) {
                LOG.error("DDL forbidden: " + e.getMessage());
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
