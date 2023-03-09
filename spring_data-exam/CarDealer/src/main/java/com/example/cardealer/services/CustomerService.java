package com.example.cardealer.services;

import com.example.cardealer.dto.OrderedCustomersDto;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public interface CustomerService {
    List<OrderedCustomersDto> findGivenCustomers() throws JAXBException;
}
