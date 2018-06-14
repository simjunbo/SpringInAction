package com.sjb.chapter5.data;

import java.util.List;

/**
 * Created by simjunbo on 2018-06-14.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
