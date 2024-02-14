package com.ordep.musicsearch.util.api;

import java.util.Arrays;
import java.util.Objects;

public class Artist extends APIObject {

	private Follower followers;
	private String[] genres;
	private Image[] images;
	private int popularity;

    public Artist(String href, String id, String name, String type, String uri,
            ExternalUrls externalUrls, Follower followers, String[] genres,
            Image[] images, int popularity) {
		super(href, id, name, type, uri, externalUrls);
        this.followers = followers;
        this.genres = genres;
        this.images = images;
        this.popularity = popularity;
	}

	public Follower getFollowers() {
		return followers;
	}
	public void setFollowers(Follower followers) {
		this.followers = followers;
	}

    public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}

    public Image[] getImages() {
		return images;
	}
	public void setImages(Image[] images) {
		this.images = images;
	}

    public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist that = (Artist) o;
        return Objects.equals(getHref(), that.getHref()) &&
            Objects.equals(getId(), that.getId()) &&
            Objects.equals(getName(), that.getName()) &&
            Objects.equals(getType(), that.getType()) &&
            Objects.equals(getUri(), that.getUri()) &&
            Objects.equals(getExternalUrls(), that.getExternalUrls()) &&
            Objects.equals(followers, that.followers) &&
            Arrays.equals(genres, that.genres) &&
            Arrays.equals(images, that.images) &&
            Objects.equals(popularity, that.popularity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHref(), getId(), getName(), getType(), getUri(),
                getExternalUrls(), followers, Arrays.hashCode(genres),
                Arrays.hashCode(images), popularity);
    }

    @Override
    public String toString() {
        return String.format("Artist{" +
                "\n\t\t\thref=\'%s\'" + 
                ",\n\t\t\tid=\'%s\'" + 
                ",\n\t\t\tname=\'%s\'" + 
                ",\n\t\t\ttype=\'%s\'" + 
                ",\n\t\t\turi=\'%s\'" + 
                ",\n\t\t\texternalUrls=\'%s\'" + 
                "\n\t\t\tfollowers=\'%s\'" +
                ",\n\t\t\tgenres=\'%s\'" +
                ",\n\t\t\timages=\'%s\'" +
                ",\n\t\t\tpopularity=\'%d\'" +
                "\n\t\t}", getHref(), getId(), getName(), getType(), getUri(),
            getExternalUrls(), followers, Arrays.toString(genres),
                Arrays.toString(images), popularity);
    }
}
