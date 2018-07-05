package com.sjb.chapter11.repository;

import com.sjb.chapter10.domain.Spitter;

import java.util.List;

/**
 * Created by simjunbo on 2018-07-02.
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

}