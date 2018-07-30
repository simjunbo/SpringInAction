package com.sjb.chapter16.data;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by simjunbo on 2018-06-14.
 */
public class Spittle {
    private Long id;
    private String message;
    private Double latitude;
    private Double longitude;

    public Spittle() {
    }

    public Spittle(Long id, String message) {
        this(id, message, null, null);
    }

    public Spittle(Long id, String message, Double longitude, Double latitude) {
        this.id = id;
        this.message = message;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
