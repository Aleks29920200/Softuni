package com.example.shoppinglist.service;


import com.example.shoppinglist.domain.enums.CategoryName;
import com.example.shoppinglist.domain.entity.Product;
import com.example.shoppinglist.domain.dto.ProductByCategory;
import com.example.shoppinglist.domain.dto.ProductDto;
import com.example.shoppinglist.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private CategoryServiceImpl categoryService;
    private ProductRepo productRepo;
    private UserServiceImpl userService;
    private ProductByCategory productByCategory;
    private ModelMapper mapper=new ModelMapper();

    public ProductServiceImpl(CategoryServiceImpl categoryService, ProductRepo productRepo, UserServiceImpl userService, ProductByCategory productByCategory) {
        this.categoryService = categoryService;
        this.productRepo = productRepo;
        this.userService = userService;
        this.productByCategory = productByCategory;
    }
    @Override
    public void addProduct(ProductDto productDto) {
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setNeededBefore(productDto.getNeededBefore());
        product.setCategory(this.categoryService.findByName(CategoryName.valueOf(productDto.getCategoryName())).get());
        this.productRepo.save(product);
    }
    @Override
    public Product findProductByName(String name) {
        return this.productRepo.findProductByName(name);
    }

    @Override
    public List<ProductDto> productsOfFoodCategory() {
        List<ProductDto> food = this.productRepo.findAll().stream().filter(e -> e.getCategory().getName().toString().equals("Food")).map(e->mapper.map(e,ProductDto.class)).collect(Collectors.toList());
        productByCategory.setFood(food);
        return food;
    }

    @Override
    public List<ProductDto> productsOfDrinkCategory() {
        List<ProductDto> drinks = this.productRepo.findAll().stream().filter(e -> e.getCategory().getName().toString().equals("Drink")).map(e->mapper.map(e,ProductDto.class)).collect(Collectors.toList());
        productByCategory.setDrink(drinks);
        return drinks;
    }

    @Override
    public List<ProductDto> productsOfHouseholdCategory() {
        List<ProductDto> household = this.productRepo.findAll().stream().filter(e -> e.getCategory().getName().toString().equals("Household")).map(e->mapper.map(e,ProductDto.class)).collect(Collectors.toList());
        productByCategory.setHousehold(household);
        return household;
    }

    @Override
    public List<ProductDto> productsOfOtherCategory() {
        List<ProductDto> other= this.productRepo.findAll().stream().filter(e -> e.getCategory().getName().toString().equals("Other")).map(e->mapper.map(e,ProductDto.class)).collect(Collectors.toList());
        productByCategory.setOther(other);
        return other;
    }

    @Override
    public void delete(Long id) {
        this.productRepo.deleteById(id);
    }

    @Override
    public Product findTheProductThatIsGoingToBeBuyed(Long id) {
        return this.productRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAllProducts() {
        this.productRepo.deleteAll();
    }
}
