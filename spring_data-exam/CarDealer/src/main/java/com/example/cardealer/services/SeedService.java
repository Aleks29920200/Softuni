package com.example.cardealer.services;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.text.ParseException;

@Service
public interface SeedService {
    void seedSupplies() throws FileNotFoundException, JAXBException;
    void seedCars() throws FileNotFoundException, JAXBException;
    void seedCustomers() throws FileNotFoundException, ParseException, JAXBException;
    void seedParts() throws FileNotFoundException, JAXBException;

    void seedSales();
}
