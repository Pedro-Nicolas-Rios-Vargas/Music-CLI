package com.ordep.musicsearch.api;

import java.util.List;
import java.util.Map;

import com.ordep.musicsearch.SearchResponse;
import com.ordep.musicsearch.util.api.Album;
import com.ordep.musicsearch.util.api.Artist;
import com.ordep.musicsearch.util.api.Track;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface ApiMusic {

    @RequestLine("GET /search")
    List<SearchResponse<Track>> songs(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /search")
    List<SearchResponse<Album>> albums(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /search")
    List<SearchResponse<Artist>> artists(@QueryMap Map<String, Object> queryMap);
}
