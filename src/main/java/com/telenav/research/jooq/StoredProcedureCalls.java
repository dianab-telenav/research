package com.telenav.research.jooq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import com.telenav.research.generated.routines.RetrieveEmptyPresentations;


/**
 *
 *
 * @author dianabalan
 */
public class StoredProcedureCalls {

    private static Logger LOG = Logger.getLogger(StoredProcedureCalls.class);

    public static void main(final String[] args) {

        final Configuration dbConfig = Configuration.INSTANCE;
        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            final org.jooq.Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.MYSQL)
                    .set(new Settings().withExecuteLogging(true));

            final RetrieveEmptyPresentations procedure = new RetrieveEmptyPresentations();

            procedure.execute(configuration);

            final int resultCount = procedure.getResultCount();

            LOG.info(resultCount + " presentations without participants.");

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
