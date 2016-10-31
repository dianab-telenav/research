package com.telenav.playground.interfaces;

import java.util.Observable;
import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Command.R;


public interface Rx {

    <C extends Command<R>, R extends Command.R> Observable observe(C command);
}