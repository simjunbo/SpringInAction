package com.sjb.chapter5.data;

/**
 * Created by simjunbo on 2018-06-15.
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}