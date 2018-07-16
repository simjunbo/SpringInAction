package com.sjb.chapter12.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by simjunbo on 2018-07-16.
 */
@NodeEntity // Order는 노드
public class Order {
    @GraphId
    private Long id;    // 그래프 ID

    private String customer;

    private String type;

    @RelatedTo(type = "HAS_ITEMS")  // 아이템의 관계
    private Set<Item> items = new LinkedHashSet<Item>();

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }
}
