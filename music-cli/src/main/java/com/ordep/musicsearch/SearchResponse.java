package com.ordep.musicsearch;

import java.util.Arrays;
import java.util.Objects;

import com.ordep.musicsearch.util.api.APIObject;

public class SearchResponse<T extends APIObject> {
    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
    private T[] items;

    public SearchResponse(String href, int limit, String next, int offset,
            String previous, int total, T[] items) {
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
        this.items = items;
    }

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public T[] getItems() {
		return items;
	}
	public void setItems(T[] items) {
		this.items = items;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // NOTE: Check this Wildcard later, maybe a headache
        SearchResponse<T> that = cast(SearchResponse.class, o);
        if (that == null) return false;
        return Objects.equals(href, that.href) &&
            Objects.equals(limit, that.limit) &&
            Objects.equals(next, that.next) &&
            Objects.equals(offset, that.offset) &&
            Objects.equals(previous, that.previous) &&
            Objects.equals(total, that.total) &&
            Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, limit, next, offset, previous, total,
                Arrays.hashCode(items));
    }

    @Override
    public String toString() {
        return String.format("SearchResponse{" +
                "href=\'%s\'" +
                ", limit=\'%d\'" +
                ", next=\'%s\'" +
                ", offset=\'%d\'" +
                ", previous=\'%s\'" +
                ", total=\'%d\'" +
                ", items=\'%s\'" +
                "}", href, limit, next, offset, previous, total, Arrays.toString(items));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SearchResponse<T> cast(Class<? extends SearchResponse> clazz,
            Object o) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException ccE) {
            return null;
        }
    }

}
