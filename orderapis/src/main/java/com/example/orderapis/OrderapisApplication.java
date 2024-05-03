package com.example.orderapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.orderapis.entity.Product;
import com.example.orderapis.entity.User;
import com.example.orderapis.repository.OrderRepository;
import com.example.orderapis.repository.ProductRepository;
import com.example.orderapis.repository.UserRepository;

@SpringBootApplication
public class OrderapisApplication implements CommandLineRunner {

	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderapisApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
  
		orderRepository.deleteAll();
		productRepository.deleteAll();
		userRepository.deleteAll();
		
		User user = new User();
		user.firstName = "John";
		user.lastName = "Doe";
		user.email = "johndoe@example.com";
		user.role = "user";
		user.username = "johndoe";
		userRepository.save(user);
		System.out.println("Insert user seed:" + user.id);
  

		for (int i = 1; i <= 10; i++) {
			Product product = new Product();
			product.name = "Product" + Integer.toString(i);
			productRepository.save(product);
			System.out.println("Insert product seed:" + product.id);
		}
	}
}
