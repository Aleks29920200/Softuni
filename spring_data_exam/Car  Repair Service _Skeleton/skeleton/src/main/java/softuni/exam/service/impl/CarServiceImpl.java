package softuni.exam.service.impl;

import org.apache.el.util.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarDto;
import softuni.exam.models.dto.CarRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.MechanicService;
import softuni.exam.service.PartService;
import softuni.exam.service.TaskService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.FilePath.CARS_IMPORT;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private XmlParser xmlParser;
    private ModelMapper mapper=new ModelMapper();
    private ValidationUtil validationUtil;
@Autowired
    public CarServiceImpl(CarRepository carRepository, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count()>0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_IMPORT));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
    StringBuilder builder=new StringBuilder();
    File file=new File(CARS_IMPORT);
        CarRootDto carRootDto = xmlParser.fromFile(file,CarRootDto.class);
        List<CarDto> cars = carRootDto.getCars();
        for (int i = 0; i < cars.size(); i++) {
            CarDto carDto = cars.get(i);
            boolean valid = validationUtil.isValid(carDto);
            if(this.carRepository.existsCarByPlateNumber(carDto.getPlateNumber())){
                valid=false;
            }
            if(valid){
                Car car = mapper.map(carDto, Car.class);
                this.carRepository.save(car);
                builder.append(String.format("Successfully imported car %s %s",car.getCarMake(),car.getCarModel())).append(System.lineSeparator());
            }else{
                builder.append("Invalid car").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    @Override
    public Car findCarById(long id) {
        return this.carRepository.findCarById(id);
    }
}

