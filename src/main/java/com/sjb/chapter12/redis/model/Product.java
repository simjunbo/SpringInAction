package com.sjb.chapter12.redis.model;

/**
 * Created by simjunbo on 2018-07-16.
 */
public class Product {
    private String sku;
    private String name;

    public Product() {
    }

    public Product(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public String name() {
        return name;
    }
}
