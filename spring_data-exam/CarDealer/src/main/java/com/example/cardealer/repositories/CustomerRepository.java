package com.example.cardealer.repositories;

import com.example.cardealer.dto.OrderedCustomersDto;
import com.example.cardealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from car_dealer.customers order by RAND() limit 1",nativeQuery = true)
    Customer randomCustomer();
    @Query("select c from Customer c order by c.birthDate,c.isYoungDriver")
    List<Customer> findGivenCustomers();
}
