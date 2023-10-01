package com.projectRaj.eCommerceAPI.service;

import com.projectRaj.eCommerceAPI.models.Orders;
import com.projectRaj.eCommerceAPI.repo.OrderRepository;
import com.projectRaj.eCommerceAPI.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public String createOrder(Orders order) {
        orderRepository.save(order);
        return "Orders placed. please stay tunned.";
    }

    public Object getOrderById(Integer orderId) {
        Optional<Orders> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            return optionalOrder;
        }
        return "Orders with id : "+orderId+" is not available";
    }
}
