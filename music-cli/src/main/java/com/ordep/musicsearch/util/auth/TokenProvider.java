package com.ordep.musicsearch.util.auth;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.function.Supplier;

import com.google.gson.Gson;
import com.ordep.musicsearch.util.api.APIFunctions;
import com.ordep.musicsearch.api.auth.APIAuth;

public class TokenProvider implements Supplier<Token> {

    public static Optional<Credentials> getCredentials() {
        Gson gson = new Gson();
        ClassLoader classloader = Thread.currentThread()
            .getContextClassLoader();

        try (InputStream credentialsFileStream = classloader.getResourceAsStream("api_credentials.json")) {
            return Optional.of(gson.fromJson(
                        new InputStreamReader(credentialsFileStream),
                        Credentials.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

	@Override
	public Token get() {
        APIAuth api = APIFunctions.buildAPI(APIAuth.class,
                "https://api.spotify.com");

        Credentials credentials = getCredentials()
            .orElse(new Credentials("client_credentials",
                        "", ""));
        String grantType = credentials.getGrantType();
        String clientId = credentials.getClientId();
        String clientSecret = credentials.getClientSecret();

        return api.getToken(grantType, clientId, clientSecret);
	}
}
