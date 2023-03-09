package com.example.dealership1.services;

import com.example.dealership1.domain.dto.BillDto;
import com.example.dealership1.domain.dto.ServiceDto;
import com.example.dealership1.domain.entity.Bill;
import com.example.dealership1.repositories.BillRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private BillRepo billRepo;
    private ServiceImpl service;
    private ModelMapper mapper;

    public BillServiceImpl(BillRepo billRepo, ServiceImpl service, ModelMapper mapper) {
        this.billRepo = billRepo;
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public List<Bill> allBills() {
        return this.billRepo.findAll();
    }

    @Override
    public Bill findById(Long id) {
        return this.billRepo.findById(id).orElse(null);
    }

    @Override
    public Bill addBill(ServiceDto serviceDto) {
        BillDto billDto=new BillDto();
        billDto.setPrice(BigDecimal.valueOf(serviceDto.getPrice()));
        billDto.setAmount(BigDecimal.valueOf(1));
        Bill bill = billRepo.saveAndFlush(mapper.map(billDto, Bill.class));
        return bill;
    }

}
