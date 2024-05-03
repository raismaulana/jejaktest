package com.example.orderapis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.orderapis.entity.User;

public interface UserRepository extends MongoRepository<User,String> {
}
