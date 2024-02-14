package com.ordep.musicsearch;

import java.util.Objects;

import com.ordep.musicsearch.util.api.Album;
import com.ordep.musicsearch.util.api.Artist;
import com.ordep.musicsearch.util.api.ResponseObject;
import com.ordep.musicsearch.util.api.Track;

public class SearchResponse {

    ResponseObject<Track> tracks;
    ResponseObject<Artist> artists;
    ResponseObject<Album> albums;

    public SearchResponse(ResponseObject<Track> tracks,
            ResponseObject<Artist> artists,
            ResponseObject<Album> albums) {
        this.tracks = tracks;
        this.artists = artists;
        this.albums = albums;
    }

	public ResponseObject<Track> getTracks() {
		return tracks;
	}
	public ResponseObject<Artist> getArtists() {
		return artists;
	}
	public ResponseObject<Album> getAlbums() {
		return albums;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SearchResponse that = (SearchResponse) obj;
        return Objects.equals(tracks, that.tracks) &&
            Objects.equals(artists, that.artists) &&
            Objects.equals(albums, that.albums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tracks, artists, albums);
    }

    @Override
    public String toString() {
        /*
        return String.format("SearchResponse{" +
                "\n\ttracks=%s" +
                ",\n\tartists=%s" +
                ",\n\talbums=%s" +
                "}", tracks, artists, albums);
        */
        String strTracks = tracks != null ? "\n\ttracks=" + tracks.toString() : "";
        String strArtists = artists != null ? "\n\tartists=" + artists.toString() : "";
        String strAlbums = albums != null ? "\n\talbums=" + albums.toString() : "";
        return String.format("SearchResponse{%s\n}",
                stringConcatenateWithJoin(strTracks,
                    strArtists,
                    strAlbums));
    }

    public static String stringConcatenateWithJoin(String... strings) {
        String res = "";
        String delimiter = "";
        int len = strings.length - 1;
        boolean needsDelimiter = false;

        int i = 0;
        while (i <= len) {
            String str = strings[i];

            if (needsDelimiter) {
                delimiter = ", ";
                needsDelimiter = false;
            }

            if (str != null && !str.isEmpty()) {
                needsDelimiter = true;
                res += delimiter + str;

                // unnecesary line but added just to define the injection of
                // delimiter was done
                delimiter = "";
            }
            i++;
        }

        return res;
    }
}
