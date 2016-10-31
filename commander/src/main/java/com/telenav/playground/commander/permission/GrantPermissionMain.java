package com.telenav.playground.commander.permission;

import java.util.Observable;
import java.util.concurrent.CompletableFuture;
import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Command.R;
import com.telenav.playground.interfaces.Future;
import com.telenav.playground.interfaces.Now;
import com.telenav.playground.interfaces.Rx;
/**
 *
 *
 * @author dianabalan
 */
public class GrantPermissionMain {

    public static void main(String[] args) {
        GrantPermission grantPermission = new GrantPermission("memba", "permission");

        grantPermission.execute(new Now() {
            @Override
            public <C extends Command<R>, R extends Command.R> R execute(C command) {
                return null;
            }
        });


        grantPermission.schedule(new Future() {
            @Override
            public <C extends Command<R>, R extends Command.R> CompletableFuture<R>
            schedule(C command) {
                return null;
            }
        });


        grantPermission.observe(new Rx() {
            @Override
            public <C extends Command<R>, R extends Command.R> Observable observe(C command) {
                return null;
            }
        });
    }
}
