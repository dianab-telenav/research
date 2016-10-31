package com.telenav.playground.commander.permission;

import java.util.List;
import org.immutables.value.Value.Enclosing;
import org.immutables.value.Value.Immutable;
import com.telenav.playground.commander.Command;

@Immutable
@Enclosing
interface GetSocialAccounts extends Command<GetSocialAccounts.R> {
    String networkerId();
    @Immutable
    interface R extends Command.R {
        List<SocialAccount> socialAccounts();
    }
}