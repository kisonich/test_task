package com.example.demo.repo;

import com.example.demo.models.OrderRow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRowRepository extends CrudRepository<OrderRow,Integer> {
}
