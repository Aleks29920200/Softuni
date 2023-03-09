package com.example.coffee_shop.service;

import com.example.coffee_shop.entity.Order;
import com.example.coffee_shop.entity.OrderDto;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderService {
void addOrder(OrderDto product);
    Order findOrderByName(String name);
    List<Order>allOrders();
    void delete(Long id);
    Order findTheProductThatIsGoingToBeBuyed(Long id);

}
