package com.example.orderapis.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.orderapis.entity.Order;

public class OrdersResponse extends Response {
    public List<Order> data = new ArrayList<>();
}
