package com.example.demo.repo;


import com.example.demo.models.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products,Integer> {
}
