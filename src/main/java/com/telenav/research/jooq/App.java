package com.telenav.research.jooq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import test.generated.Tables;


/**
 * Hello world!
 * 
 */
public class App {

    public static void main(final String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itdays_db", "root", "1234")) {

            final DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            /**
             * insert
             */
            create.insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME, Tables.PARTICIPANT.EMAIL)
                    .values("silviu", "diana@mail.com").execute();

            /**
             * update
             */
            create.update(Tables.PARTICIPANT).set(Tables.PARTICIPANT.NUME, "new name")
                    .where(Tables.PARTICIPANT.ID.equal(2)).execute();

            /**
             * select
             */
            final Result<Record> result = create.select().from(Tables.PARTICIPANT).fetch();


            for (final Record r : result) {
                final Integer id = r.getValue(Tables.PARTICIPANT.ID);
                final String name = r.getValue(Tables.PARTICIPANT.NUME);
                final String email = r.getValue(Tables.PARTICIPANT.EMAIL);
                System.out.println("ID: " + id + "  name: " + name + " email: " + email);
            }


        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
