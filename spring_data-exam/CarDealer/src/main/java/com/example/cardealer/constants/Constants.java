package com.example.cardealer.constants;

import java.nio.file.Path;

public enum Constants {
    ;
    final public static Path SUPPLIERS_INPUT= Path.of("src","main","resources","input","suppliersInput.json");
    final public static Path PARTS_INPUT= Path.of("src","main","resources","input","parts.json");
    final public static Path CARS_INPUT= Path.of("src","main","resources","input","cars.json");
    final public static Path XML_CUSTOMERS_INPUT= Path.of("src","main","resources","input","customers.xml");
    final public static Path XML_SUPPLIERS_INPUT= Path.of("src","main","resources","input","suppliers.xml");
    final public static Path XML_PARTS_INPUT= Path.of("src","main","resources","input","parts.xml");
    final public static Path XML_CARS_INPUT= Path.of("src","main","resources","input","cars.xml");

    final public static Path XML_ORDERED_CUSTOMERS= Path.of("src","main","resources","output","orderedCustomers.xml");
    final public static Path XML_TOYOTA= Path.of("src","main","resources","output","toyota.xml");
    final public static Path XML_CARS_WITH_PARTS= Path.of("src","main","resources","output","carsWithParts.xml");
    final public static Path XML_CUSTOMERS_WITH_TOTAL_SALES= Path.of("src","main","resources","output","" +
            "");
}
