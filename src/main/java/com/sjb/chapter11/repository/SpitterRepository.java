package com.sjb.chapter11.repository;

import com.sjb.chapter11.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.Order;
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

    @Query("select s from Spitter s where s.email like '%gmail.com'")
    List<Spitter> findAllGmailSpitters();
}