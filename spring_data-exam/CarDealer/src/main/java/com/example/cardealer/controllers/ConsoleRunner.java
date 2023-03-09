package com.example.cardealer.controllers;

import com.example.cardealer.constants.Constants;
import com.example.cardealer.dto.*;
import com.example.cardealer.services.*;
import com.example.cardealer.xml.XmlParser;
import com.example.cardealer.xml.XmlParserImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
private SeedService seedService;
private CustomerService customerService;
private CarService carService;
private SaleService saleService;

    final private XmlParser xmlParser=new XmlParserImpl();

    public ConsoleRunner(SeedService seedService,CustomerService customerService,CarService carService,SaleService saleService) {
        this.seedService = seedService;
        this.customerService=customerService;
        this.carService=carService;
        this.saleService=saleService;
    }

    @Override
    public void run(String... args) throws Exception {
      // seedService.seedSupplies();
   // seedService.seedParts();
     // seedService.seedCars();
     //   seedService.seedCustomers();
     //   seedService.seedSales();
       //List<OrderedCustomersDto> givenCustomers = this.customerService.findGivenCustomers();
     // OrderedCustomersRootDto orderedCustomersRootDto=new OrderedCustomersRootDto();
     // orderedCustomersRootDto.setCustomers(givenCustomers);
     // xmlParser.exportToXml(orderedCustomersRootDto, OrderedCustomersRootDto.class, Constants.XML_ORDERED_CUSTOMERS);
     //  List<CarDto> toyotaCar = this.carService.findByMakeIsLike("Toyota");
     //   CarToyotaRootDto toyota=new CarToyotaRootDto();
      //  toyota.setToyotas(toyotaCar);
     //   xmlParser.exportToXml(toyota,CarToyotaRootDto.class,Constants.XML_TOYOTA);
        //List<CarsWithParts> carsWithParts = this.carService.carsWithParts();
       // CarsWithPartsRootDto cars=new CarsWithPartsRootDto();
      //  cars.setCars(carsWithParts);
      //  xmlParser.exportToXml(cars,CarsWithPartsRootDto.class,Constants.XML_CARS_WITH_PARTS);
        List<CustomerTotalSales> customerTotalSales = this.saleService.CustomerWithTotalSales();
        CustomerTotalSalesRoot sales=new CustomerTotalSalesRoot();
        sales.setSales(customerTotalSales);
        xmlParser.exportToXml(sales,CustomerTotalSalesRoot.class, Constants.XML_CUSTOMERS_WITH_TOTAL_SALES);
    }
}
