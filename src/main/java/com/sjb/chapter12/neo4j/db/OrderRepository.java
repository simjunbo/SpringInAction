package com.sjb.chapter12.neo4j.db;

import com.sjb.chapter12.neo4j.model.Order;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * Created by simjunbo on 2018-07-16.
 */
public interface OrderRepository extends GraphRepository<Order> {
    // 쿼리메소드
    List<Order> findByCustomer(String customer);

    List<Order> findByCustomerLike(String customer);

    List<Order> findByCustomerAndType(String customer, String type);

    List<Order> getByType(String type);

    // Native Query
    @Query("{customer:'Chuck Wagon'}")
    List<Order> findChucksOrders();
}
