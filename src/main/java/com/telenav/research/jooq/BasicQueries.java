package com.telenav.research.jooq;

import static org.jooq.impl.DSL.max;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import com.telenav.research.generated.Tables;


/**
 * Hello world!
 *
 */
public class BasicQueries {

    public static void main(final String[] args) {

        final Configuration dbConfig = Configuration.INSTANCE;
        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            final DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            // insert
            create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                    .values("vasile", "vasile@mail.com").execute();

            // select max id
            final int maxId = create.select(max(Tables.PARTICIPANT.ID).as("maximum")).from(Tables.PARTICIPANT)
                    .fetchOne().value1();

            // count records
            final int countRecords = create.selectCount().from(Tables.PARTICIPANT).fetchOne(0, int.class);

            System.out.println("Number of records: " + countRecords);

            System.out.println("***************************");

            // join - many to many
            final Result<Record> afterDate = create.select().from(Tables.PARTICIPANT_PREZENTARE).join(Tables.PREZENTARE)
                    .on(Tables.PREZENTARE.ID.equal(Tables.PARTICIPANT_PREZENTARE.ID_PREZENTARE))
                    .join(Tables.PARTICIPANT)
                    .on(Tables.PARTICIPANT.ID.equal(Tables.PARTICIPANT_PREZENTARE.ID_PARTICIPANT))
                    .where(Tables.PREZENTARE.TITLU.like("Jooq")).fetch();

            System.out.println("People attending Jooq presentation");
            for (final Record r : afterDate) {
                final Integer id = r.getValue(Tables.PARTICIPANT.ID);
                final String name = r.getValue(Tables.PARTICIPANT.NUME);
                final String email = r.getValue(Tables.PARTICIPANT.EMAIL);
                System.out.println("ID: " + id + " name: " + name + " email: " + email);
            }
            System.out.println("***************************");

           
            /**
             * update last record
             */
            create.update(Tables.PARTICIPANT).set(Tables.PARTICIPANT.NUME, "new name")
                    .where(Tables.PARTICIPANT.ID.equal(maxId)).execute();

            // basic select
            final Result<Record> participants = create.select().from(Tables.PARTICIPANT).fetch();

            for (final Record r : participants) {
                final Integer id = r.getValue(Tables.PARTICIPANT.ID);
                final String name = r.getValue(Tables.PARTICIPANT.NUME);
                final String email = r.getValue(Tables.PARTICIPANT.EMAIL);
                System.out.println("ID: " + id + " name: " + name + " email: " + email);
            }
            
            //TODO - group by, order


        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
