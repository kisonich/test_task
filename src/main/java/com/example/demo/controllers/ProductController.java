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
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderRowRepository orderRowRepository;

    @GetMapping("/products")
    public List<Products> getProducts(){
        Iterable<Products> productList = productRepository.findAll();
        ArrayList<Products> myList = new ArrayList<Products>();
        productList.forEach(myList::add);
        return myList;
    }

    @GetMapping("/products/{id}")
    public Products getProduct(@PathVariable Integer id){
        Products product = productRepository.findById(id).orElseThrow();
        return product;
    }

    @PostMapping("/products/create")
    public Products addProduct(@RequestBody Products product){
        productRepository.save(product);
        return product;
    }

    @PutMapping("/products/update")
    public Products updateProduct(@RequestBody Products product){
        productRepository.save(product);
        return product;
    }

    @DeleteMapping("/products/{id}/delete")
    public Integer deleteProduct(@PathVariable Integer id){
        productRepository.deleteById(id);
        return id;
    }

}
