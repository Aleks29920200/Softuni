package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicDto;
import softuni.exam.models.dto.PartDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.FilePath.MECHANICS_IMPORT;

@Service

public class MechanicServiceImpl implements MechanicService {
    private Gson gson=new Gson();
    private ModelMapper mapper=new ModelMapper();
    private ValidationUtil validationUtil;
    private MechanicRepository mechanicRepository;
@Autowired
    public MechanicServiceImpl(ValidationUtil validationUtil, MechanicRepository mechanicRepository) {
        this.validationUtil = validationUtil;
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public boolean areImported() {
        return this.mechanicRepository.count()>0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_IMPORT));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder builder=new StringBuilder();
        List<MechanicDto> mechanics= Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicDto[].class)).toList();
        for (MechanicDto mechanicDto : mechanics) {
            boolean valid = validationUtil.isValid(mechanicDto);
            if (this.mechanicRepository.existsMechanicByEmail(mechanicDto.getEmail())) {
                valid = false;
            }
            if (valid) {
                Mechanic mechanic = mapper.map(mechanicDto, Mechanic.class);
                this.mechanicRepository.save(mechanic);
                builder.append(String.format("Successfully imported mechanic %s %s", mechanic.getFirstName(), mechanic.getLastName())).append(System.lineSeparator());
            } else {
                builder.append("Invalid mechanic").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    @Override
    public Mechanic findMechanicByFirstName(String firstName) {
        return this.mechanicRepository.findMechanicByFirstName(firstName);
    }

    @Override
    public boolean existsMechanicByFirstName(String firstName) {
        return this.mechanicRepository.existsMechanicByFirstName(firstName);
    }
}
