package com.ordep.musicsearch.util.api;

import java.util.Objects;

public class Image {

    private String url;
	private int height;
	private int width;

    public Image(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Image that = (Image) obj;
        return Objects.equals(url, that.url) &&
            Objects.equals(height, that.height) &&
            Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, height, width);
    }

    @Override
    public String toString() {
        return String.format("Image{" +
                "url=\'%s\'" +
                ", height=\'%d\'" +
                ", width=\'%d\'" +
                "}", url, height, width);
    }
}
