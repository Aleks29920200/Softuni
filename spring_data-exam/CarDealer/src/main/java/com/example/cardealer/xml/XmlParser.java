package com.example.cardealer.xml;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;

public interface XmlParser {
        <O> O parseXml(Class<O> objectClass, Path filePath) throws JAXBException;
        <O> void exportToXml(O object, Class<O> objectClass,Path path) throws JAXBException;
    }

