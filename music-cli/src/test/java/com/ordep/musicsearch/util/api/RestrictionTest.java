package com.ordep.musicsearch.util.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.ordep.musicsearch.util.api.Restriction;
import com.ordep.musicsearch.util.api.Restriction.RestrictionReason;

public class RestrictionTest {
    
    private Gson gson;

    @BeforeEach
    public void init() {
        gson = new Gson();
    }

    @Test
    public void restriction_object_to_json() {
        Restriction restriction = new Restriction(RestrictionReason.EXPLICIT);
        Restriction restriction2 = new Restriction(RestrictionReason.valueOf("MARKET"));

        assertEquals("{\"reason\":\"EXPLICIT\"}", gson.toJson(restriction));
        assertEquals("{\"reason\":\"MARKET\"}", gson.toJson(restriction2));
    }

    @Test
    public void empty_json_to_restriction_object() {
        assertEquals(new Restriction(null),
                gson.fromJson("{}", Restriction.class));
    }
}
