package com.sjb.chapter12.mongodb;

import com.sjb.chapter12.model.Order;

import java.util.List;

/**
 * Created by simjunbo on 2018-07-11.
 */
public interface OrderOperations {
    List<Order> findOrdersByType(String t);
}
