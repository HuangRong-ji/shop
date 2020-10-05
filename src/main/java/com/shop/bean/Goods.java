package com.shop.bean;

import java.math.BigDecimal;

public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String producer;
    private Integer sales;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";

    public Goods() {

    }

    public Goods(Integer id, String name, BigDecimal price, String producer, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    public Goods(String name, BigDecimal price, String producer, Integer sales, Integer stock, String imgPath) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
