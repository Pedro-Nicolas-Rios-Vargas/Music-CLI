package com.ordep.musicsearch.util.auth;

import java.util.function.Supplier;

import feign.Request;
import feign.RequestTemplate;
import feign.Target;

public class AuthTokenTarget<T> implements Target<T> {

    private Class<T> clazz;
    private Supplier<Token> provider;
    private String url;

    public AuthTokenTarget(Class<T> clazz, Supplier<Token> provider, String url) {
        this.clazz = clazz;
        this.provider = provider;
        this.url = url;
    }

	@Override
	public Class<T> type() {
		throw new UnsupportedOperationException("Unimplemented method 'type'");
	}

	@Override
	public String name() {
		throw new UnsupportedOperationException("Unimplemented method 'name'");
	}

	@Override
	public String url() {
        return url;
	}

	@Override
	public Request apply(RequestTemplate input) {
        Token token = provider.get();

        if (input.url().indexOf("http") != 0) {
            input.target(url);
        }

        input.header("Authorization",
                String.format("%s %s",
                    token.getTokenType(),
                    token.getAccessToken()));

        return input.request();
	}
}
