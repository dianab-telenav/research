package com.telenav.research.jooq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import com.telenav.research.generated.Tables;


/**
 *
 *
 * @author dianabalan
 */
public class TransactionManagement {

    public static void main(final String[] args) {
        final Configuration dbConfig = Configuration.INSTANCE;

        try (final Connection conn =
                DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword())) {

            final DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            try {

                create.transaction(outer -> {

                    System.out.println("Insert into participant valid data.");
                    DSL.using(outer).insertInto(Tables.PARTICIPANT, Tables.PARTICIPANT.NUME).values("not commited")
                            .returning().fetchOne();

                    try {
                        DSL.using(outer).transaction(inner -> {
                            System.out.println("Trying to insert topic that does not exist.");
                            try {
                                DSL.using(inner).insertInto(Tables.PREZENTARE, Tables.PREZENTARE.TITLU,
                                        Tables.PREZENTARE.ID_TOPIC).values("titlu 1", 7).returning().fetchOne();
                            } catch (final DataAccessException e) {
                                System.out.println("Problem, cannot insert");
                                throw e;
                            }
                        });
                    } catch (final DataAccessException e) {
                        System.out.println("don't insert into participant either, rollback transaction");
                        throw e;
                    }

                    System.out.println("should not get here...");
                });

            } catch (final DataAccessException e) {
                System.out.println("Transaction was rolled back");
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
