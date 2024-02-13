package com.ordep.musicsearch.util.auth;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Credentials {
    @SerializedName("grant_type")
    private String grantType;
    @SerializedName("client_id")
    private String clientId;
    @SerializedName("client_secret")
    private String clientSecret;

    public Credentials(String grantType,
            String clientId,
            String clientSecret) {

        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }
    public String getClientId() {
        return clientId;
    }
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Credentials that = (Credentials) obj;
        return Objects.equals(grantType, that.grantType) &&
            Objects.equals(clientId, that.clientId) &&
            Objects.equals(clientSecret, that.clientSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grantType, clientId, clientSecret);
    }
}
