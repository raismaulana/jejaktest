package com.example.orderapis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.orderapis.entity.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
