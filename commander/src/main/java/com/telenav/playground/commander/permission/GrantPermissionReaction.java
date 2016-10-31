package com.telenav.playground.commander.permission;

import com.telenav.playground.commander.Command;
import com.telenav.playground.commander.Reaction;
import com.telenav.playground.commander.Command.R;
import com.telenav.playground.commander.Command.R.Void;
import com.telenav.playground.commander.permission.model.Member;
import com.telenav.playground.commander.permission.model.MemberId;
import com.telenav.playground.commander.permission.model.Members;
import com.telenav.playground.commander.permission.model.Permission;
import com.telenav.playground.commander.permission.model.PermissionId;


public class GrantPermissionReaction implements Reaction<GrantPermission, Command.R.Void> {

    private final Members members;
    private final Permission permissions;

    public GrantPermissionReaction(Permission permissions, Members members) {
        this.members = members;
        this.permissions = permissions;
    }

    @Override
    public Void react(GrantPermission command) {
        MemberId memberId = new MemberId(command.memberId());
        Member member = members.byId(memberId);
        PermissionId permissionId = new PermissionId(command.permissionId());
        Permission permission = permissions.byId(permissionId);
        member.grantPermission(permission);
        return new Command.R.Void();
    }

}