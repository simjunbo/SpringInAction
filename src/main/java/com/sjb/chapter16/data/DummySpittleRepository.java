package com.sjb.chapter16.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simjunbo on 2018-06-15.
 */
@Component
public class DummySpittleRepository implements SpittleRepository {

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle(1L, "Hello");
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 1; i <= count; i++) {
            spittles.add(new Spittle(Long.valueOf(i), "Spittle " + i, 0.0, 0.0));
        }
        return spittles;
    }

    @Override
    public Spittle save(Spittle spittle) {
        return spittle;
    }
}