package com.example.coffee_shop.repository;

import com.example.coffee_shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findProductByName(String name);

}
