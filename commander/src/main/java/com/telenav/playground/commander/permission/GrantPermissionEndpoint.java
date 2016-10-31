package com.telenav.playground.commander.permission;

import java.util.Observable;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Command.R;
import com.telenav.playground.commander.Command.R.Void;
import com.telenav.playground.interfaces.Durable;
import com.telenav.playground.interfaces.Future;
import com.telenav.playground.interfaces.Now;
import com.telenav.playground.interfaces.Rx;


@RestController
public class GrantPermissionEndpoint {

    @Autowired
    private Now now;

    @Autowired
    private Future future;

    @Autowired
    private Rx rx;

    @Autowired
    private Durable durable;

    @PostMapping("/users/{memberId}/permissions/now")
    Command.R.Void accept(@PathVariable String memberId, @RequestParam String permissionId) {
        GrantPermission grantPermission = new GrantPermission(memberId, permissionId);
        return now.execute(grantPermission);
    }


    @PostMapping("/users/{memberId}/permissions/schedule")
    public CompletableFuture<Command.R.Void> schedule(@PathVariable String memberId,
            @RequestParam String permissionId) {
        GrantPermission grantPermission = new GrantPermission(memberId, permissionId);
        return future.schedule(grantPermission);
    }

    @PostMapping("/users/{memberId}/permissions/observe")
    public Observable observe(@PathVariable String memberId,
            @RequestParam String permissionId) {
        GrantPermission grantPermission = new GrantPermission(memberId, permissionId);
        return rx.observe(grantPermission);
    }

    @PostMapping("/users/{memberId}/permissions/enqueue")
    public void enqueue(@PathVariable String memberId, @RequestParam String permissionId) {
        GrantPermission grantPermission = new GrantPermission(memberId, permissionId);
        durable.enqueue(grantPermission);
    }

}