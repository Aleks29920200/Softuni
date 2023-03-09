package com.example.cardealer.repositories;

import com.example.cardealer.entities.Car;
import com.example.cardealer.entities.Customer;
import com.example.cardealer.entities.Part;
import com.example.cardealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "select * from car_dealer.cars order by RAND() limit 1",nativeQuery = true)
    Car randomCar();

    List<Car> findByMakeIsLike(String make);
    @Query(value = "select * from car_dealer.cars c ",nativeQuery = true)
    List<Car>carsWithParts();
}

