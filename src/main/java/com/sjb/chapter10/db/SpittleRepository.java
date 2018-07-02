package com.sjb.chapter10.db;

import com.sjb.chapter10.domain.Spittle;

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