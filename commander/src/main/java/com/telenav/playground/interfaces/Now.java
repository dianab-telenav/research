package com.telenav.playground.interfaces;

import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Command.R;

public interface Now {

    <C extends Command<R>, R extends Command.R> R execute(C command);
}