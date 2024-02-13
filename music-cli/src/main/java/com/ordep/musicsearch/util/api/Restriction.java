package com.ordep.musicsearch.util.api;

import java.util.Objects;

public class Restriction {
    public enum RestrictionReason {
        MARKET, PRODUCT, EXPLICIT
    }
    private RestrictionReason reason;

    public Restriction(RestrictionReason reason) {
        this.reason = reason;
    }

	public RestrictionReason getReason() {
		return reason;
	}
	public void setReason(RestrictionReason reason) {
		this.reason = reason;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Restriction that = (Restriction) obj;
        return Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }

    @Override
    public String toString() {
        return String.format("Restriction{" +
                "reason=\'%s\'" +
                "}", reason);
    }
}
