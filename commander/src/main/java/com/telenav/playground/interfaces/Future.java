package com.telenav.playground.interfaces;

import java.util.concurrent.CompletableFuture;
import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Command.R;


public interface Future {

    <C extends Command<R>, R extends Command.R> CompletableFuture<R> schedule(C command);
}