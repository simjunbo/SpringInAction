package com.sjb.chapter16.data;

import java.util.List;

/**
 * Created by simjunbo on 2018-06-14.
 */
public interface SpittleRepository {
    Spittle findOne(long spittleId);

    List<Spittle> findSpittles(long max, int count);

    Spittle save(Spittle spittle);
}
