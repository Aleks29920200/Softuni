package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.FilePath.PART_IMPORT;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;
    private Gson gson=new Gson();
    private ModelMapper mapper=new ModelMapper();
    private ValidationUtil validationUtil;
@Autowired
    public PartServiceImpl(PartRepository partRepository,ValidationUtil validationUtil) {
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.partRepository.count()>0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PART_IMPORT));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder builder=new StringBuilder();
        List<PartDto> parts = Arrays.stream(gson.fromJson(readPartsFileContent(), PartDto[].class)).toList();
        for (PartDto partDto : parts) {
            boolean valid = validationUtil.isValid(partDto);
            if (this.partRepository.existsPartByPartName(partDto.getPartName())) {
                valid = false;
            }
            if (valid) {
                Part part = mapper.map(partDto, Part.class);
                this.partRepository.save(part);
                builder.append(String.format("Successfully imported part %s - %.2f", part.getPartName(), part.getPrice())).append(System.lineSeparator());
            } else {
                builder.append("Invalid part").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    @Override
    public Part findPartById(long id) {
        return this.partRepository.findPartById(id);
    }
}
