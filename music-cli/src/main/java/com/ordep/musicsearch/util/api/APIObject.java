package com.ordep.musicsearch.util.api;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class APIObject {

	private String href;
	private String id;
	private String name;
	private String type;
	private String uri;
    @SerializedName("external_urls")
    private ExternalUrls externalUrls;

    public APIObject(String href,
            String id,
            String name,
            String type,
            String uri,
            ExternalUrls externalUrls) {

        this.href = href;
        this.id = id;
        this.name = name;
        this.type = type;
        this.uri = uri;
        this.externalUrls = externalUrls;
    }

    public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

    public ExternalUrls getExternalUrls() {
		return externalUrls;
	}
	public void setExternalUrls(ExternalUrls externalUrls) {
		this.externalUrls = externalUrls;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APIObject that = (APIObject) o;
        return Objects.equals(href, that.href) &&
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(type, that.type) &&
            Objects.equals(uri, that.uri) &&
            Objects.equals(externalUrls, that.externalUrls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, id, name, type, uri, externalUrls);
    }

    @Override
    public String toString() {
        return String.format("APIObject{" +
                "href=\'%s\'" +
                ", id=\'%s\'" +
                ", name=\'%s\'" +
                ", type=\'%s\'" +
                ", uri=\'%s\'" +
                ", externalUrls=\'%s\'" +
                "}", href, id, name, type, uri, externalUrls);
    }
}
