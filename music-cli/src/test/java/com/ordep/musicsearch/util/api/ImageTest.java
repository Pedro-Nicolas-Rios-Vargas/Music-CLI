package com.ordep.musicsearch.util.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.ordep.musicsearch.util.api.Image;

public class ImageTest {
    private Gson gson;

    @BeforeEach
    public void init() {
        gson = new Gson();
    }

    @Test
    public void image_to_json() {
        Image image = new Image("link_to_image.png", 500, 400);

        assertEquals("{\"url\":\"link_to_image.png\",\"height\":500,\"width\":400}",
                gson.toJson(image));
    }

    @Test
    public void image_with_null_url_to_json() {
        Image image = new Image(null, 500, 400);

        assertEquals("{\"height\":500,\"width\":400}",
                gson.toJson(image));
    }

    @Test
    public void image_with_empty_url_to_json() {
        Image image = new Image("", 500, 400);

        assertEquals("{\"url\":\"\",\"height\":500,\"width\":400}",
                gson.toJson(image));
    }

    @Test
    public void json_without_fields_to_image() {
        assertEquals(new Image("url", 0, 100),
                gson.fromJson("{\"url\":\"url\",\"width\":100}", Image.class));
    }
}
