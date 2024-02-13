package com.ordep.musicsearch.util.api;

import java.util.Objects;

public class ExternalUrls {
    private String spotify;

    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }

	public String getSpotify() {
		return spotify;
	}

	public void setSpotify(String spotify) {
		this.spotify = spotify;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalUrls that = (ExternalUrls) o;
        return Objects.equals(spotify, that.spotify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotify);
    }

    @Override
    public String toString() {
        return String.format("ExternalUrls{" +
                "spotify=\'%s\'" +
                "}", spotify);
    }
}
