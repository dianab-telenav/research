package com.telenav.playground.commander.permission;

import java.util.List;
import org.immutables.value.Value.Enclosing;
import org.immutables.value.Value.Immutable;
import com.telenav.playground.commander.Command;

@Immutable
@Enclosing
interface GetSocialConnections extends Command<GetSocialConnections.R> {
    SocialAccount socialAccount();
    @Immutable
    interface R extends Command.R {
        List<SocialConnection> connections();
    }
}