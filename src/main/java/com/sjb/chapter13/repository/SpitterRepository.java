package com.sjb.chapter13.repository;

import com.sjb.chapter13.domain.Spitter;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by simjunbo on 2018-07-02.
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}