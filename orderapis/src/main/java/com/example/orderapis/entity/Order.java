package com.example.orderapis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
    
    @Id
    public String id;
    
    public Integer amount;
    public Integer status;

    @DBRef
    public User userId;

    @DBRef
    public Product productId;

}
