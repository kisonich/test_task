package com.example.demo.controllers;

import com.example.demo.models.Order;
import com.example.demo.models.OrderRow;
import com.example.demo.models.Products;
import com.example.demo.repo.OrderRepository;
import com.example.demo.repo.OrderRowRepository;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderRowRepository orderRowRepository;


    @GetMapping("/orders")
    public List<Order> getOrders(){
        Iterable<Order> ordersList = orderRepository.findAll();
        ArrayList<Order> myList = new ArrayList<Order>();
        ordersList.forEach(myList::add);
        return myList;
    }

    @DeleteMapping("/orders/{id}/delete")
    public Integer deleteProduct(@PathVariable Integer id){
        orderRepository.deleteById(id);
        return id;
    }


    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Integer id){
        Order order = orderRepository.findById(id).orElseThrow();
        return order;
    }


    @PutMapping("/orders/update")
    public Order updateOrder(@RequestBody Order order){
        Collection<OrderRow> collection = new ArrayList<OrderRow>();
        if(order.getOrderRowsById() != null){
            for(OrderRow orderRow : order.getOrderRowsById()) {
                orderRowRepository.save(orderRow);
                if(orderRowRepository.existsById(orderRow.getId())){
                    collection.add(orderRowRepository.findById(orderRow.getId()).orElseThrow());
                }else{
                    orderRowRepository.save(orderRow);
                    collection.add(orderRow);
                }
            }
        }
        order.setOrderRowsById(collection);
        orderRepository.save(order);
        for(OrderRow orderRow : collection) {
            orderRow.setOrderByOrderId(order);
            orderRowRepository.save(orderRow);
        }

        return order;
    }


    @PostMapping("/orders/create")
    public Order addOrder(@RequestBody Order order){
        Collection<OrderRow> collection = new ArrayList<OrderRow>();
        if(order.getOrderRowsById() != null){
            for(OrderRow orderRow : order.getOrderRowsById()) {
                orderRowRepository.save(orderRow);
                if(orderRowRepository.existsById(orderRow.getId())){
                    collection.add(orderRowRepository.findById(orderRow.getId()).orElseThrow());
                }else{
                    orderRowRepository.save(orderRow);
                    collection.add(orderRow);
                }
            }
        }
        order.setOrderRowsById(collection);
        orderRepository.save(order);
        for(OrderRow orderRow : collection) {
            orderRow.setOrderByOrderId(order);
            orderRowRepository.save(orderRow);
        }

        return order;
    }

}
