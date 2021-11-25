package com.example.demo.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Table(name = "\"order\"")
@Entity
public class Order {
    private int id;
    private Integer number;
    private String clientEmail;
    private Timestamp createTime;
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
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "clientEmail", nullable = true, length = 255)
    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(number, order.number) && Objects.equals(clientEmail, order.clientEmail) && Objects.equals(createTime, order.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, clientEmail, createTime);
    }

    @OneToMany(mappedBy = "orderByOrderId", cascade = CascadeType.ALL)
    public Collection<OrderRow> getOrderRowsById() {
        return orderRowsById;
    }

    public void setOrderRowsById(Collection<OrderRow> orderRowsById) {
        this.orderRowsById = orderRowsById;
    }
}
