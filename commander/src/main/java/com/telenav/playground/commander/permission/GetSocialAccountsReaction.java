package com.telenav.playground.commander.permission;

import com.telenav.playground.commander.Reaction;
import com.telenav.playground.commander.permission.model.ImmutableSocialAccount;

public class GetSocialAccountsReaction implements Reaction<GetSocialAccounts, GetSocialAccounts.R> {

    @Override
    public GetSocialAccounts.R react(GetSocialAccounts command) {
        SocialAccount facebook = ImmutableSocialAccount.builder().type(SocialAccountType.FB)
                .username("facebook@devchampions.com").build();
        SocialAccount twitter = ImmutableSocialAccount.builder().type(SocialAccountType.TW)
                .username("twitter@devchampions.com").build();

        return ImmutableGetSocialAccounts.R.builder().addSocialAccounts(facebook, twitter).build();
    }

}