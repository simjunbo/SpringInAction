package com.sjb.chapter16.exception;

/**
 * Created by simjunbo on 2018-07-31.
 */
public class SpittleNotFoundException extends RuntimeException {
    private long spittleId;

    public SpittleNotFoundException(long spittleId) {
        this.spittleId = spittleId;
    }

    public long getSpittleId() {
        return spittleId;
    }
}
