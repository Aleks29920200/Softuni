package com.example.cardealer.services;

import com.example.cardealer.dto.CarDto;
import com.example.cardealer.dto.CarsWithParts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarDto> findByMakeIsLike(String make);
    List<CarsWithParts> carsWithParts();
}

