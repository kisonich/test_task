package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@Table(name = "\"products\"")
@Entity
public class Products {
    private int id;
    private Integer price;
    private String name;


    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Collection<OrderRow> orderRowsById;

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
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id && Objects.equals(price, products.price) && Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }

    @OneToMany(cascade =CascadeType.ALL,
            mappedBy = "productsByProductId")
    public Collection<OrderRow> getOrderRowsById() {
        return orderRowsById;
    }

    public void setOrderRowsById(Collection<OrderRow> orderRowsById) {
        this.orderRowsById = orderRowsById;
    }
}
