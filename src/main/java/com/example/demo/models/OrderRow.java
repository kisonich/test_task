package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "\"order_row\"", schema = "public", catalog = "test_db_postgres")
public class OrderRow {
    private int id;
    private Integer currentPrice;
    private Integer count;
    private Integer total;
    private Products productsByProductId;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Order orderByOrderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "currentPrice", nullable = true)
    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "total", nullable = true)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRow orderRow = (OrderRow) o;
        return id == orderRow.id && Objects.equals(currentPrice, orderRow.currentPrice) && Objects.equals(count, orderRow.count) && Objects.equals(total, orderRow.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentPrice, count, total);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = true) ////// , referencedColumnName = "id", nullable = true
    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id" , referencedColumnName = "id", nullable = true)  //// , referencedColumnName = "id", nullable = true
    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
