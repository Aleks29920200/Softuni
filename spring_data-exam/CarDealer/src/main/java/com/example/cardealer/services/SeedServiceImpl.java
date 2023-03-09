package com.example.cardealer.services;

import com.example.cardealer.xml.XmlParser;
import com.example.cardealer.xml.XmlParserImpl;
import com.example.cardealer.dto.*;
import com.example.cardealer.dto.CustomerInputDto;
import com.example.cardealer.entities.*;
import com.example.cardealer.repositories.*;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.IntStream;

import static com.example.cardealer.constants.Constants.*;


@Service
public class SeedServiceImpl implements SeedService {
    Set<Part>parts=new HashSet<>();
    Random random=new Random();
    ModelMapper mapper=new ModelMapper();
    private SupplierRepository supplierRepository;
    private PartRepository partRepository;
    private CarRepository carRepository;
    private CustomerRepository customerRepository;

    private SaleRepository saleRepository;

    final public static Gson GSON=new GsonBuilder().setDateFormat("DD/MM/YY").excludeFieldsWithoutExposeAnnotation().create();
    private XmlParser xmlParser;


    public SeedServiceImpl(SupplierRepository supplierRepository,PartRepository partRepository,CarRepository carRepository,CustomerRepository customerRepository,SaleRepository saleRepository) {
        this.supplierRepository = supplierRepository;
        this.partRepository=partRepository;
        this.carRepository=carRepository;
        this.customerRepository=customerRepository;
        this.saleRepository=saleRepository;
        this.xmlParser=new XmlParserImpl();
    }
    @Override
    public void seedSupplies() throws FileNotFoundException, JAXBException {
        SupplierRootDto list = this.xmlParser.parseXml(SupplierRootDto.class,XML_SUPPLIERS_INPUT);

        for (SupplierInputDto supplierDto: list.getSupplierDtos()) {
            this.supplierRepository.saveAndFlush(this.mapper.map(supplierDto, Supplier.class));
        }
    }

    @Override
    public void seedCars() throws FileNotFoundException, JAXBException {
        CarRootDto list = this.xmlParser.parseXml(CarRootDto.class,XML_CARS_INPUT);
        for (CarInputDto carDto: list.getCarDtoList()) {
            CarInputDto carInputDto = setRandomParts(carDto);
            this.carRepository.saveAndFlush(this.mapper.map(carInputDto, Car.class));
        }
    }
    private CarInputDto setRandomParts(CarInputDto car) {
        int i = random.nextInt(2)+1;
            for (int k = 1; k < i; k++) {
                Part part=this.partRepository.randomParts();
                parts.add(part);
            }
        car.setParts(parts.stream().toList());
        return car;
    }
    @Override
    public void seedCustomers() throws FileNotFoundException, ParseException, JAXBException {
        CustomerRootDto list = this.xmlParser.parseXml(CustomerRootDto.class,XML_CUSTOMERS_INPUT);

        for (CustomerInputDto customerDto: list.getCustomers()) {
            Customer customer = this.mapper.map(customerDto, Customer.class);
            customer.setBirthDate(customerDto.getBirthDate());
            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public void seedParts() throws FileNotFoundException,JAXBException {
        PartRootDto list = this.xmlParser.parseXml(PartRootDto.class,XML_PARTS_INPUT);
        for (PartInputDto partDto: list.getPartDtos()) {
            PartInputDto partInputDto = setRandomSupplier(partDto);
            this.partRepository.saveAndFlush(this.mapper.map(partInputDto,Part.class));
        }
    }

    @Override
    public void seedSales() {
        double[]discounts=new double[]{0.05,0.10,0.15,0.20,0.30,0.40,0.50};
        List<Sale>sales=new ArrayList<>();
        IntStream.iterate(0, i -> i < this.carRepository.count(), i -> i + 1).mapToObj(i -> this.carRepository.randomCar()).forEach(car -> {
            Sale sale = new Sale();
            sale.setCar(car);
            sales.add(sale);
        });
        sales.forEach(inputDto -> {
            Customer customer = this.customerRepository.randomCustomer();
            inputDto.setCustomer(customer);
        });
        Random random=new Random();
        sales.forEach(sale -> {
            double random1 = getRandom(discounts);
            sale.setDiscount(BigDecimal.valueOf(random1));
        });
      this.saleRepository.saveAll(sales);
    }

    public PartInputDto setRandomSupplier(PartInputDto t) {
        Supplier supplier = this.supplierRepository.randomSupplier();
        t.setSupplierDto(supplier);
        return t;
    }
    public static double getRandom(double[]discounts){
        int i = new Random().nextInt(discounts.length);
        return discounts[i];
    }
}
