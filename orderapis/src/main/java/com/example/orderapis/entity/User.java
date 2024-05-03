package com.example.orderapis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    
    @Id
    public String id;
    
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String role;

}
