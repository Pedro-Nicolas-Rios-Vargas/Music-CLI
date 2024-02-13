package com.ordep.musicsearch.util.api;

import feign.Feign;
import feign.Target;
import feign.gson.GsonDecoder;

public interface APIFunctions {
    static <T> T buildAPI(Class<T> clazz, String url) {
        return Feign.builder()
            .decoder(new GsonDecoder())
            .target(clazz, url);
    }

    static <T> T buildAPI(Target<T> target) {
        return Feign.builder()
            .decoder(new GsonDecoder())
            .target(target);
    }
}
