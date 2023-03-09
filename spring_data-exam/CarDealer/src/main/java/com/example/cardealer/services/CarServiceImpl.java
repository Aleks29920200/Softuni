package com.example.cardealer.services;

import com.example.cardealer.dto.CarDto;
import com.example.cardealer.dto.CarsWithParts;
import com.example.cardealer.entities.Car;
import com.example.cardealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private CarRepository carRepository;

    private ModelMapper mapper=new ModelMapper();
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> findByMakeIsLike(String make) {
        List<Car> toyota = this.carRepository.findByMakeIsLike(make);
        List<CarDto> carDtos = toyota.stream().map(e -> mapper.map(e, CarDto.class)).toList();
        return carDtos;
    }

    @Override
    public List<CarsWithParts> carsWithParts() {
        List<Car> cars = this.carRepository.carsWithParts();
        List<CarsWithParts> carsWithParts = cars.stream().map(e -> mapper.map(e, CarsWithParts.class)).toList();
        return carsWithParts;
    }
}

