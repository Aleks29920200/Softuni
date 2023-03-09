package com.example.cardealer.services;

import com.example.cardealer.xml.XmlParser;
import com.example.cardealer.xml.XmlParserImpl;
import com.example.cardealer.dto.OrderedCustomersDto;
import com.example.cardealer.entities.Customer;
import com.example.cardealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
   final private XmlParser xmlParser=new XmlParserImpl();

   final ModelMapper mapper=new ModelMapper();

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<OrderedCustomersDto> findGivenCustomers() throws JAXBException {
       List<Customer> givenCustomers = this.customerRepository.findGivenCustomers();
        List<OrderedCustomersDto> orderedCustomersDtos = givenCustomers.stream().map(e -> mapper.map(e, OrderedCustomersDto.class)).toList();
        return orderedCustomersDtos;
    }
}
