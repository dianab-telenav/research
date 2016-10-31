package com.telenav.playground.commander;

import java.util.Collection;
import java.util.Collections;
import java.util.Observable;
import java.util.concurrent.CompletableFuture;
import com.telenav.playground.interfaces.Durable;
import com.telenav.playground.interfaces.Future;
import com.telenav.playground.interfaces.Now;
import com.telenav.playground.interfaces.Rx;


public interface Command<T extends Command.R> {

    interface R {
        class Void implements Command.R {}
    }

    interface TxFlag {

        TxFlag READ_ONLY = tx -> tx.setReadOnly(true);

        void apply(TransactionTemplate tx);
    }

    default Collection<TxFlag> txFlags() {
        return Collections.emptyList();
    }

    default T execute(Now now) {
        return now.execute(this);
    }

    default CompletableFuture<T> schedule(Future future) {
        return future.schedule(this);
    }

    default Observable observe(Rx rx) {
        return rx.observe(this);
    }

    default void enqueue(Durable durable) {
        durable.enqueue(this);
    }
}