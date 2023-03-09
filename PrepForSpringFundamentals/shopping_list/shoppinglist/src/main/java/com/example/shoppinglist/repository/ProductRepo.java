package com.example.shoppinglist.repository;

import com.example.shoppinglist.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findProductByName(String name);

}
