package com.telenav.playground.commander.permission;

import com.telenav.playground.commander.Reaction;

class GetSocialConnectionsReactionStub implements Reaction<GetSocialConnections, GetSocialConnections.R> {

    @Override
    public GetSocialConnections.R react(GetSocialConnections $) {
        return ImmutableGetSocialConnections.R.builder().addConnections(randomConnection())
                .addConnections(randomConnection())
                .addConnections(randomConnection()).build();
    }

    private ImmutableSocialConnection randomConnection() {
        return ImmutableSocialConnection.builder().emailAddress("dummy@mail.com").build();
    }
}