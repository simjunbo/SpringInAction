package com.sjb.chapter9.data;

import com.sjb.chapter9.Spitter;

/**
 * Created by simjunbo on 2018-06-15.
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}