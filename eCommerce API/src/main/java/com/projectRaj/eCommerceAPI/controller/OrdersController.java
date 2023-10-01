package com.projectRaj.eCommerceAPI.controller;

import com.projectRaj.eCommerceAPI.models.Orders;
import com.projectRaj.eCommerceAPI.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping("api/userId/productId/addressId/productQuantity")
    public String placeOrder(@RequestBody Orders order){
        return ordersService.createOrder(order);
    }

    @GetMapping("api/order/{orderId}")
    public Object getOrderById(@PathVariable Integer orderId){
        return ordersService.getOrderById(orderId);
    }

}
