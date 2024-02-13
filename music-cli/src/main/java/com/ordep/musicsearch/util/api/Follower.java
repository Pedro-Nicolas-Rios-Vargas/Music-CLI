package com.ordep.musicsearch.util.api;

import java.util.Objects;

public class Follower {

    private String href;
    private int total;

    public Follower(String href, int total) {
        this.href = href;
        this.total = total;
    }

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Follower that = (Follower) obj;
        return Objects.equals(href, that.href) &&
            Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, total);
    }

    @Override
    public String toString() {
        return String.format("Follower{" +
                "href=\'%s\'" +
                ", total=\'%d\'" +
                "}", href, total);
    }
}
