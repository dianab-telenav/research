package com.telenav.research.jooq;

import static org.jooq.impl.DSL.max;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.ExecuteType;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import com.telenav.research.generated.Tables;


public class BasicQueries {

    private static Logger LOG = Logger.getLogger(BasicQueries.class);

    public static void main(final String[] args) {

        final Configuration dbConfig = Configuration.INSTANCE;
        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            final org.jooq.Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.MYSQL)
                    .set(new Settings().withExecuteLogging(true));
            configuration.set(new DefaultExecuteListenerProvider(new StatisticsListener()));

            final DSLContext create = DSL.using(configuration);

            // insert
            create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                    .values("vasile", "vasile@mail.com").execute();

            // select max id
            final int maxId = create.select(max(Tables.PARTICIPANT.ID).as("maximum")).from(Tables.PARTICIPANT)
                    .fetchOne().value1();

            // count records
            final int countRecords = create.selectCount().from(Tables.PARTICIPANT).fetchOne(0, int.class);

            LOG.info("Number of records: " + countRecords);
            LOG.info("***************************");

            // join - many to many
            final Result<Record1<String>> afterDate =
                    create.select(Tables.PARTICIPANT.NUME).from(Tables.PARTICIPANT_PREZENTARE).join(Tables.PREZENTARE)
                            .on(Tables.PREZENTARE.ID.equal(Tables.PARTICIPANT_PREZENTARE.ID_PREZENTARE))
                            .join(Tables.PARTICIPANT)
                            .on(Tables.PARTICIPANT.ID.equal(Tables.PARTICIPANT_PREZENTARE.ID_PARTICIPANT))
                            .where(Tables.PREZENTARE.TITLU.like("Jooq")).fetch();

            LOG.info("People attending Jooq presentation");
            LOG.info(afterDate.toString());
            LOG.info("***************************");

            /**
             * update last record
             */
            create.update(Tables.PARTICIPANT).set(Tables.PARTICIPANT.NUME, "new name")
                    .where(Tables.PARTICIPANT.ID.equal(maxId)).execute();

            // basic select - can fetch results normally, into result of record
            final Result<Record> participantsRecords = create.select().from(Tables.PARTICIPANT).fetch();

            /*
             * basic select - can fetch results into mapped POJO. OBS! there must be an exact match between projected
             * fields and available constructors.
             */
            @SuppressWarnings("unused")
            final List<Participant> participants =
                    create.select(Tables.PARTICIPANT.ID, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                            .from(Tables.PARTICIPANT).fetch().into(Participant.class);

            LOG.info(participantsRecords.toString());


            LOG.info("***************************");
            LOG.info("Executions statistics: ");
            for (final ExecuteType type : ExecuteType.values()) {
                LOG.info(type.name() + " " + StatisticsListener.STATISTICS.get(type) + " executions");
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
