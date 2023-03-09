package com.example.dealership1.services;

import com.example.dealership1.domain.binding.AddServiceDto;

@org.springframework.stereotype.Service
public interface Service{
    com.example.dealership1.domain.entity.Service findServiceByName(String name);
    void saveService(AddServiceDto serviceDto);
com.example.dealership1.domain.entity.Service findServiceById(Long id);
    void deleteById(Long id);
}
