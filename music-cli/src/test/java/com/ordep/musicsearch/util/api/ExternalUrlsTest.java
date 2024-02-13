package com.ordep.musicsearch.util.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.ordep.musicsearch.util.api.ExternalUrls;

public class ExternalUrlsTest {
    private Gson gson;

	@BeforeEach
    public void init() {
        gson = new Gson();
    }

    @Test
    public void externalUrls_to_json() {
        ExternalUrls extUrls = new ExternalUrls("spotify external url");

        assertEquals("{\"spotify\":\"spotify external url\"}",
                gson.toJson(extUrls));
    }

    @Test
    public void externalUrls_with_null_to_json() {
        ExternalUrls extUrls = new ExternalUrls(null);

        assertEquals("{}", gson.toJson(extUrls));
    }

    @Test
    public void externalUrls_with_empty_string_to_json() {
        ExternalUrls extUrls = new ExternalUrls("");

        assertEquals("{\"spotify\":\"\"}",
                gson.toJson(extUrls));
    }

    @Test
    public void json_to_externalUrls() {
        assertEquals(new ExternalUrls("hoal"),
                gson.fromJson("{\"spotify\":\"hoal\"}", ExternalUrls.class));
    }

    @Test
    public void empty_json_to_externalUrls() {
        assertEquals(new ExternalUrls(null),
                gson.fromJson("{}", ExternalUrls.class));
    }

    @Test
    public void json_with_empty_string_to_externalUrls() {
        assertEquals(new ExternalUrls(""),
                gson.fromJson("{\"spotify\":\"\"}", ExternalUrls.class));
    }
}
