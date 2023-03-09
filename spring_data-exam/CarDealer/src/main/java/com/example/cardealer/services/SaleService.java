package com.example.cardealer.services;

import com.example.cardealer.dto.CustomerTotalSales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    List<CustomerTotalSales> CustomerWithTotalSales();
}
