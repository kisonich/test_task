package com.example.demo.controllers;

import com.example.demo.models.Products;
import com.example.demo.repo.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void addProduct() {
        Products products = new Products();
        products.setName("Test product 777");
        products.setPrice(7777);

        Products productsNew = new Products();
        productsNew.setName(products.getName());
        productsNew.setPrice(products.getPrice());

        Products resProducts = productController.addProduct(productsNew);

        Assertions.assertTrue(products.equals(resProducts));
    }


}