package com.example.dealership1.services;

import com.example.dealership1.domain.binding.AddServiceDto;
import com.example.dealership1.domain.entity.ServiceCategory;
import com.example.dealership1.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
    private ServiceRepo repo;
@Autowired
    public ServiceImpl(ServiceRepo repo) {
        this.repo = repo;
    }

    @Override
    public com.example.dealership1.domain.entity.Service findServiceByName(String name) {
        return this.repo.findServiceByName(name);
    }

    @Override
    public void saveService(AddServiceDto serviceDto) {
        com.example.dealership1.domain.entity.Service service=new com.example.dealership1.domain.entity.Service();
        service.setName(serviceDto.getName());
        service.setPrice(serviceDto.getPrice());
        service.setCategory(ServiceCategory.valueOf(serviceDto.getCategory()));
        repo.save(service);
    }
    @Override
    public com.example.dealership1.domain.entity.Service findServiceById(Long id) {
        return this.repo.findServiceById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.repo.deleteById(id);
    }
}
