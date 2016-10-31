package com.telenav.playground.interfaces;

import com.telenav.playground.commander.Command;

public interface Durable {
    <C extends Command> void enqueue(C command);
}