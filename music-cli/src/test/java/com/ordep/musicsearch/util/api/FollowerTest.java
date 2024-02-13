package com.ordep.musicsearch.util.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.ordep.musicsearch.util.api.Follower;

public class FollowerTest {
    private Gson gson;

	@BeforeEach
    public void init() {
        gson = new Gson();
    }

    @Test
    public void follower_object_to_json() {
        assertEquals("{\"href\":\"href:follower\",\"total\":45}",
                gson.toJson(new Follower("href:follower", 45)));
    }

    public void json_to_follower_object() {
        assertEquals(new Follower("href:follower", 43),
                gson.fromJson("{\"href\":\"href:follower\",\"total\":43}",
                    Follower.class));
    }
}
