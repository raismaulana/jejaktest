package com.example.orderapis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.orderapis.entity.Order;
import com.example.orderapis.entity.User;

public interface OrderRepository extends MongoRepository<Order,String> {
    public List<Order> findByUserId(User userId);
}
