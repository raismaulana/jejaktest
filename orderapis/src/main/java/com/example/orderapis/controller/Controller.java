package com.example.orderapis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderapis.dto.request.CreateOrderRequest;
import com.example.orderapis.dto.response.OrderResponse;
import com.example.orderapis.dto.response.OrdersResponse;
import com.example.orderapis.entity.Order;
import com.example.orderapis.entity.Product;
import com.example.orderapis.entity.User;
import com.example.orderapis.repository.OrderRepository;
import com.example.orderapis.repository.ProductRepository;
import com.example.orderapis.repository.UserRepository;

@RestController
public class Controller {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/order") 
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest req) {
        OrderResponse response = new OrderResponse();

        if (!req.isValid()) {
            response.status = 400;
            response.message = "Invalid body param";
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Product> product = productRepository.findById(req.productId);
        if (!product.isPresent()) {
            response.status = 400;
            response.message = "Product is not found";
            return ResponseEntity.badRequest().body(response);
        }
        Optional<User> user = userRepository.findById(req.userId);
        if (!user.isPresent()) {
            response.status = 400;
            response.message = "User is not found";
            return ResponseEntity.badRequest().body(response);
        }

        Order order = new Order();
        order.status = 1;
        order.amount = req.amount;
        order.productId = product.get();
        order.userId = user.get();

        order = orderRepository.save(order);

        response.message = "OK";
        response.status = 200;
        response.data = order;
        return ResponseEntity.ok(response);   
    }

    @GetMapping("/order") 
    public ResponseEntity<OrdersResponse> getOrders(@RequestParam String userId) {
        OrdersResponse response = new OrdersResponse();
        

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            response.status = 400;
            response.message = "User is not found";
            return ResponseEntity.badRequest().body(response);
        }

        List<Order> orders = orderRepository.findByUserId(user.get());
        
        response.message = "OK";
        response.status = 200;
        response.data = orders;
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/order/{orderId}") 
    public ResponseEntity<OrderResponse> deleteOrder(@PathVariable(value = "orderId")  String id) {
        OrderResponse response = new OrderResponse();

        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            response.status = 400;
            response.message = "Order is not found";
            return ResponseEntity.badRequest().body(response);
        }
        orderRepository.deleteById(id);

        response.message = "OK";
        response.status = 200;
        response.data = order.get();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/user") 
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/product") 
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
