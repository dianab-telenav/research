package com.telenav.playground.commander;

public interface Reaction<C extends Command<R>, R extends Command.R> {

    R react(C command);
}