package com.sjb.chapter13.repository;

import com.sjb.chapter13.domain.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by simjunbo on 2018-07-02.
 */
public interface SpittleRepository {

    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    @Cacheable(value = "spittleCache", unless = "#result.message.contains('NoCache')", condition = "#id >= 10")
    Spittle findOne(long id);

    @CachePut(value = "spittleCache", key = "#result.id")
    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    @PostAuthorize("returnObject.spitter.username == principal.username")
    Spittle getSpittleById(long id);

    @PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
    @PostFilter("hasRole('ROLE_ADMIN') || " + "filterObject.spitter.username == pricipal.name")
    List<Spittle> getOffensiveSpittles();

    @PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
    @PostFilter("hasRole('ROLE_ADMIN') || " + "filterObject.spitter.username == pricipal.name")
    void deleteSpittles(List<Spittle> spittles);


    @CacheEvict("spittleCache")
    void remove(long id);

}