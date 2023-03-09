package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.Product;
import com.example.shoppinglist.domain.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductService {
void addProduct(ProductDto product);
    Product findProductByName(String name);
    List<ProductDto>productsOfFoodCategory();
    List<ProductDto>productsOfDrinkCategory();
    List<ProductDto>productsOfHouseholdCategory();
    List<ProductDto>productsOfOtherCategory();
    void delete(Long id);
    Product findTheProductThatIsGoingToBeBuyed(Long id);
    void deleteAllProducts();
}
