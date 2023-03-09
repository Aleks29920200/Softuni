package com.example.cardealer.services;

import com.example.cardealer.dto.CustomerTotalSales;
import com.example.cardealer.entities.Sale;
import com.example.cardealer.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{
private SaleRepository saleRepository;
private ModelMapper mapper=new ModelMapper();

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<CustomerTotalSales> CustomerWithTotalSales() {
        List<Sale> sales = this.saleRepository.CustomerWithTotalSales();
        List<CustomerTotalSales> customerTotalSales = sales.stream().map(e -> mapper.map(e, CustomerTotalSales.class)).toList();
        return customerTotalSales;
    }
}
