package com.telenav.playground.commander.permission;

import org.immutables.value.Value.Immutable;

/**
 *
 *
 * @author dianabalan
 */
@Immutable
public interface SocialAccount {

    SocialAccountType type(); // FB, TW, LN

    String username();
}
