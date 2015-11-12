package com.telenav.research.jooq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.ExecuteType;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import com.telenav.research.generated.Tables;


/**
 *
 *
 * @author dianabalan
 */
public class BatchExection {

    private static Logger LOG = Logger.getLogger(BasicQueries.class);

    public static void main(final String[] args) {
        final Configuration dbConfig = Configuration.INSTANCE;

        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {
            final org.jooq.Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.MYSQL);
            configuration.set(new DefaultExecuteListenerProvider(new StatisticsListener()));

            final DSLContext create = DSL.using(configuration);

            create.batch(
                    create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                            .values("Ioana", "ioana@mail.com"),
                    create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                            .values("Gheorghe", "gheorghe"),
                    create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                            .values("Oana", "oana@mail.com"))
                    .execute();

            create.batch(create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                    .values((String) null, (String) null)).bind("Ana", "ana@mail.com").bind("Ion", "ion@mail.com")
                    .bind("Laurentiu", "laur@mail.com").bind("Bogdan", "bogdan@mail.com").execute();

            LOG.info("Executions statistics: ");
            for (final ExecuteType type : ExecuteType.values()) {
                LOG.info(type.name() + " " + StatisticsListener.STATISTICS.get(type) + " executions");
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
