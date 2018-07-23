package com.sjb.chapter13.repository;

import com.sjb.chapter13.domain.Spittle;

import java.util.List;

/**
 * Created by simjunbo on 2018-07-02.
 */
public interface SpittleRepository {

    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);

}