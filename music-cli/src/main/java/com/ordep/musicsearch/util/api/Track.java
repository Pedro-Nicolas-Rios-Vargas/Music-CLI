package com.ordep.musicsearch.util.api;

import java.util.Arrays;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Track extends APIObject {

	public class ExternalIds {

        private String isrc;
		private String ean;
		private String upc;

        public ExternalIds(String isrc, String ean, String upc) {
            this.isrc = isrc;
            this.ean = ean;
            this.upc = upc;
        }

		public String getIsrc() {
			return isrc;
		}
		public void setIsrc(String isrc) {
			this.isrc = isrc;
		}

        public String getEan() {
			return ean;
		}
		public void setEan(String ean) {
			this.ean = ean;
		}

        public String getUpc() {
			return upc;
		}
		public void setUpc(String upc) {
			this.upc = upc;
		}

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ExternalIds that = (ExternalIds) obj;
            return Objects.equals(isrc, that.isrc) &&
                Objects.equals(ean, that.ean) &&
                Objects.equals(upc, that.upc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isrc, ean, upc);
        }

        @Override
        public String toString() {
            return String.format("ExternalIds{" +
                    "isrc=\'%s\'" +
                    ", ean=\'%s\'" +
                    ", upc=\'%s\'" +
                    "}", isrc, ean, upc);
        }
    }

    private Album album;
	private Artist[] artists;
	@SerializedName("available_markets")
    private String[] availableMarkets;
	@SerializedName("disc_number")
    private int discNumber;
	@SerializedName("duration_ms")
    private int durationMs;
	private boolean explicit;
	@SerializedName("external_ids")
    private ExternalIds[] externalIds;
	@SerializedName("is_playable")
    private boolean isPlayable;
	@SerializedName("linked_from")
    private String linkedFrom;
	private Restriction restrictions;
	private int popularity;
	@SerializedName("preview_url")
    private String previewUrl;
	@SerializedName("track_number")
    private int trackNumber;
	@SerializedName("is_local")
    private boolean isLocal;

    public Track(String href, String id, String name, String type, String uri,
            ExternalUrls externalUrls, Album album, Artist[] artists,
            String[] availableMarkets, int discNumber, int durationMs,
            boolean explicit, ExternalIds[] externalIds, boolean isPlayable,
            String linkedFrom, Restriction restrictions, int popularity,
            String previewUrl, int trackNumber, boolean isLocal) {

		super(href, id, name, type, uri, externalUrls);
        this.album = album;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.explicit = explicit;
        this.externalIds = externalIds;
        this.isPlayable = isPlayable;
        this.linkedFrom = linkedFrom;
        this.restrictions = restrictions;
        this.popularity = popularity;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
        this.isLocal = isLocal;
	}

	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}

    public Artist[] getArtists() {
		return artists;
	}
	public void setArtists(Artist[] artists) {
		this.artists = artists;
	}

    public String[] getAvailableMarkets() {
		return availableMarkets;
	}
	public void setAvailableMarkets(String[] availableMarkets) {
		this.availableMarkets = availableMarkets;
	}

    public int getDiscNumber() {
		return discNumber;
	}
	public void setDiscNumber(int discNumber) {
		this.discNumber = discNumber;
	}

    public int getDurationMs() {
		return durationMs;
	}
	public void setDurationMs(int durationMs) {
		this.durationMs = durationMs;
	}

    public boolean isExplicit() {
		return explicit;
	}
	public void setExplicit(boolean explicit) {
		this.explicit = explicit;
	}

    public ExternalIds[] getExternalIds() {
		return externalIds;
	}
	public void setExternalIds(ExternalIds[] externalIds) {
		this.externalIds = externalIds;
	}

    public boolean isPlayable() {
		return isPlayable;
	}
	public void setPlayable(boolean isPlayable) {
		this.isPlayable = isPlayable;
	}

    public String getLinkedFrom() {
		return linkedFrom;
	}
	public void setLinkedFrom(String linkedFrom) {
		this.linkedFrom = linkedFrom;
	}

    public Restriction getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(Restriction restrictions) {
		this.restrictions = restrictions;
	}

    public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

    public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

    public int getTrackNumber() {
		return trackNumber;
	}
	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

    public boolean isLocal() {
		return isLocal;
	}
	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track that = (Track) o;
        return Objects.equals(album, that.album) &&
            Arrays.equals(artists, that.artists) &&
            Arrays.equals(availableMarkets, that.availableMarkets) &&
            Objects.equals(discNumber, that.discNumber) &&
            Objects.equals(durationMs, that.durationMs) &&
            Objects.equals(explicit, that.explicit) &&
            Arrays.equals(externalIds, that.externalIds) &&
            Objects.equals(isPlayable, that.isPlayable) &&
            Objects.equals(linkedFrom, that.linkedFrom) &&
            Objects.equals(restrictions, that.restrictions) &&
            Objects.equals(popularity, that.popularity) &&
            Objects.equals(previewUrl, that.previewUrl) &&
            Objects.equals(trackNumber, that.trackNumber) &&
            Objects.equals(isLocal, that.isLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, Arrays.hashCode(artists),
                Arrays.hashCode(availableMarkets), discNumber, durationMs,
                explicit, Arrays.hashCode(externalIds), isPlayable, linkedFrom,
                restrictions, popularity, previewUrl, trackNumber, isLocal);
    }

    @Override
    public String toString() {
        return String.format("Track{" +
                "album=\'%s\'" + 
                ", artists=\'%s\'" + 
                ", availableMarkets=\'%s\'" + 
                ", discNumber=\'%d\'" + 
                ", durationMs=\'%d\'" + 
                ", explicit=\'%b\'" + 
                ", externalIds=\'%s\'" + 
                ", isPlayable=\'%b\'" + 
                ", linkedFrom=\'%s\'" + 
                ", restrictions=\'%s\'" + 
                ", popularity=\'%d\'" + 
                ", previewUrl=\'%s\'" + 
                ", trackNumber=\'%d\'" + 
                ", isLocal=\'%b\'" + 
                "}", album, Arrays.toString(artists),
                Arrays.toString(availableMarkets), discNumber, durationMs,
                explicit, Arrays.toString(externalIds), isPlayable, linkedFrom,
                restrictions, popularity, previewUrl, trackNumber, isLocal);
    }
}
