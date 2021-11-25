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
public class OrderRowController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderRowRepository orderRowRepository;


    @GetMapping("/orderrows/{id}")
    public OrderRow getOrder(@PathVariable Integer id){
        OrderRow orderRow = orderRowRepository.findById(id).orElseThrow();
        return orderRow;
    }

    @PutMapping("/orderrows/update")
    public OrderRow updateProduct(@RequestBody OrderRow orderRow){
        orderRowRepository.save(orderRow);
        return orderRow;
    }

    @PostMapping("/orderrows/create")
    public OrderRow addProduct(@RequestBody OrderRow orderRow){
        orderRowRepository.save(orderRow);
        return orderRow;
    }

    @DeleteMapping("/orderrows/{id}/delete")
    public Integer deleteProduct(@PathVariable Integer id){
        orderRowRepository.deleteById(id);
        return id;
    }

}
