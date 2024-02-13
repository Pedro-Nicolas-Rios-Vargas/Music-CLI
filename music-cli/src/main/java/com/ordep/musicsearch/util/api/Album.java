package com.ordep.musicsearch.util.api;

import java.util.Arrays;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Album extends APIObject {

	public enum AlbumType {
        ALBUM, SINGLE, COMPILATION
    }

    public enum DatePrecision {
        DAY, MONTH, YEAR
    }

    @SerializedName("album_type")
    private AlbumType albumType;

	@SerializedName("total_tracks")
    private int totalTracks;

	@SerializedName("available_markets")
    private String[] availableMarkets;

	private Image[] images;

	@SerializedName("release_date")
    private String releaseDate;

	@SerializedName("release_date_precision")
    private DatePrecision releaseDatePrecision;

	private Restriction restrictions;

	private Artist[] artists;

    public Album(String href, String id, String name, String type, String uri,
            ExternalUrls externalUrls, AlbumType albumType, int totalTracks,
            String[] availableMarkets, Image[] images, String releaseDate,
            DatePrecision releaseDatePrecision, Restriction restrictions,
            Artist[] artists) {
		super(href, id, name, type, uri, externalUrls);
        this.albumType = albumType;
        this.totalTracks = totalTracks;
        this.availableMarkets = availableMarkets;
        this.images = images;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.restrictions = restrictions;
        this.artists = artists;
	}

	public AlbumType getAlbumType() {
		return albumType;
	}
	public void setAlbumType(AlbumType albumType) {
		this.albumType = albumType;
	}

    public int getTotalTracks() {
		return totalTracks;
	}
	public void setTotalTracks(int totalTracks) {
		this.totalTracks = totalTracks;
	}

    public String[] getAvailableMarkets() {
		return availableMarkets;
	}
	public void setAvailableMarkets(String[] availableMarkets) {
		this.availableMarkets = availableMarkets;
	}

    public Image[] getImages() {
		return images;
	}
	public void setImages(Image[] images) {
		this.images = images;
	}

    public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

    public DatePrecision getReleaseDatePrecision() {
		return releaseDatePrecision;
	}
	public void setReleaseDatePrecision(DatePrecision releaseDatePrecision) {
		this.releaseDatePrecision = releaseDatePrecision;
	}

    public Restriction getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(Restriction restrictions) {
		this.restrictions = restrictions;
	}


    public Artist[] getArtists() {
		return artists;
	}
	public void setArtists(Artist[] artists) {
		this.artists = artists;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album that = (Album) o;
        return Objects.equals(albumType, that.albumType) &&
            Objects.equals(totalTracks, that.totalTracks) &&
            Arrays.equals(availableMarkets, that.availableMarkets) &&
            Arrays.equals(images, that.images) &&
            Objects.equals(releaseDate, that.releaseDate) &&
            Objects.equals(releaseDatePrecision, that.releaseDatePrecision) &&
            Objects.equals(restrictions, that.restrictions) &&
            Arrays.equals(artists, that.artists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumType, totalTracks,
                Arrays.hashCode(availableMarkets), Arrays.hashCode(images),
                releaseDate, releaseDatePrecision, restrictions,
                Arrays.hashCode(artists));
    }

    @Override
    public String toString() {
        return String.format("Album{" +
                "albumType=\'%s\'" +
                ", totalTracks=\'%d\'" +
                ", availableMarkets=\'%s\'" +
                ", images=\'%s\'" +
                ", releaseDate=\'%s\'" +
                ", releaseDatePrecision=\'%s\'" +
                ", restrictions=\'%s\'" +
                ", artists=\'%s\'" +
                "}", albumType, totalTracks, Arrays.toString(availableMarkets),
                Arrays.toString(images), releaseDate, releaseDatePrecision,
                restrictions, Arrays.toString(artists));
    }
}
