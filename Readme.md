# Order Apis

before run, please change the mongodb config in the `application.properties`

run:
```bash
./mvnw spring-boot:run
```

## API Documentation:
Get User:
```
curl --location 'localhost:8080/user'
```
Get Product:
```
curl --location 'localhost:8080/product'
```
Get Orders:
As a User, I can see my order
```
curl --location 'localhost:8080/order?userId={UserId}'
```
Create Order:
As a User, I can order a product
```
curl --location 'localhost:8080/order' \
--header 'Content-Type: application/json' \
--data '{
    "userId":"userId",
    "productId":"productId",
    "amount":1
}'
```
Delete Order:
As a User, I can delete my order
```
curl --location --request DELETE 'localhost:8080/order/{OrderId}'
```