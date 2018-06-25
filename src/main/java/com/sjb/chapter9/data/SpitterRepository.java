package com.sjb.chapter9.data;

/**
 * Created by simjunbo on 2018-06-15.
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}