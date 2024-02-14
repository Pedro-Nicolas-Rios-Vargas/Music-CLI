package com.ordep.musicsearch.api.auth;

import com.ordep.musicsearch.util.auth.Token;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/x-www-form-urlencoded")
public interface APIAuth {

    @RequestLine("POST /api/token")
    @Body("grant_type={grant_type}&client_id={client_id}&client_secret={client_secret}")
    Token getToken(
            @Param("grant_type") String grantType,
            @Param("client_id") String clientId,
            @Param("client_secret") String clientSecret);
}
