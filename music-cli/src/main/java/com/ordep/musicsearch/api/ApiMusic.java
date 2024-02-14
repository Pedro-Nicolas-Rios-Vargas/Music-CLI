package com.ordep.musicsearch.api;

import java.util.Map;

import com.ordep.musicsearch.SearchResponse;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface ApiMusic {

    @RequestLine("GET /search")
    SearchResponse songs(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /search")
    SearchResponse albums(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /search")
    SearchResponse artists(@QueryMap Map<String, Object> queryMap);
}
