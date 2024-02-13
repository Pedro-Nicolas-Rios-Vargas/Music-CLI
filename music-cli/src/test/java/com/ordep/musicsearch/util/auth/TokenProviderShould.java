package com.ordep.musicsearch.util.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TokenProviderShould {
    @Test
    public void get_credentials_from_resources() {
        Credentials expectedCredentials = new Credentials("client_credentials",
                "XXX-XXX-XXX",
                "YYY-YYY-YYY");

        assertEquals(expectedCredentials, TokenProvider.getCredentials().get());
    }
}
