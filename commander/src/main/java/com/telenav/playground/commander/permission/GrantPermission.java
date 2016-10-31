package com.telenav.playground.commander.permission;

import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Command.R;
import com.telenav.playground.commander.Command.R.Void;

public class GrantPermission implements Command<Command.R.Void> {

    private final String memberId;
    private final String permissionId;

    public GrantPermission(String memberId, String permissionId) {
        this.memberId = memberId;
        this.permissionId = permissionId;
    }
    public String memberId() {
        return memberId;
    }
    public String permissionId() {
        return permissionId;
    }
}