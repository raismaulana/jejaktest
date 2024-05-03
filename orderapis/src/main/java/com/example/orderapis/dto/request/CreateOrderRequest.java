package com.example.orderapis.dto.request;

public class CreateOrderRequest {
    public String userId;
    public String productId;
    public Integer amount;

    public Boolean isValid()  {
        return !(this.userId.isEmpty() || this.productId.isEmpty() || this.amount == 0);
    }
}
