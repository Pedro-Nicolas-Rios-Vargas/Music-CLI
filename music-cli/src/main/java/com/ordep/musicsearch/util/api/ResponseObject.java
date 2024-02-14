package com.ordep.musicsearch.util.api;

import java.util.Arrays;
import java.util.Objects;

public class ResponseObject<T extends APIObject> {
    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
    private T[] items;

    public ResponseObject(String href, int limit, String next, int offset,
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

	public int getLimit() {
		return limit;
	}

	public String getNext() {
		return next;
	}

	public int getOffset() {
		return offset;
	}

	public String getPrevious() {
		return previous;
	}

	public int getTotal() {
		return total;
	}

	public T[] getItems() {
		return items;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseObject<T> that = cast(ResponseObject.class, o);
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
        return String.format("ResponseObject{" +
                "\n\t\thref=\'%s\'" +
                ",\n\t\tlimit=\'%d\'" +
                ",\n\t\tnext=\'%s\'" +
                ",\n\t\toffset=\'%d\'" +
                ",\n\t\tprevious=\'%s\'" +
                ",\n\t\ttotal=\'%d\'" +
                ",\n\t\titems=\'%s\'" +
                "\n\t}", href, limit, next, offset, previous, total,
                Arrays.toString(items));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private ResponseObject<T> cast(Class<? extends ResponseObject> clazz,
            Object o) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException ccE) {
            return null;
        }
    }
}
