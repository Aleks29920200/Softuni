package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskDto;
import softuni.exam.models.dto.TaskRootDto;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.TaskRepository;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static softuni.exam.FilePath.TASKS_IMPORT;

@Service
public class TaskServiceImpl implements TaskService {
    private MechanicService mechanicService;
    private PartService partService;
    private CarService carService;
    private TaskRepository taskRepository;
    private XmlParser xmlParser;
    private ModelMapper mapper=new ModelMapper();
    private ValidationUtil validationUtil;
@Autowired
    public TaskServiceImpl(MechanicService mechanicService, PartService partService, CarService carService, TaskRepository taskRepository, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.mechanicService = mechanicService;
        this.partService = partService;
        this.carService = carService;
        this.taskRepository = taskRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.taskRepository.count()>0;
    }

    @Override
    public String readTasksFileContent() throws IOException {

        return Files.readString(Path.of(TASKS_IMPORT));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder builder=new StringBuilder();
        File file=new File(TASKS_IMPORT);
        TaskRootDto taskRootDto = xmlParser.fromFile(file, TaskRootDto.class);
        List<TaskDto> tasks = taskRootDto.getTask();
        for (TaskDto taskDto : tasks) {
            boolean valid = validationUtil.isValid(taskDto);
            if (!this.mechanicService.existsMechanicByFirstName(taskDto.getMechanic().getFirstName())) {
                valid = false;
            }
            if (valid) {
                Task task = mapper.map(taskDto, Task.class);
                task.setDate(LocalDateTime.parse(taskDto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                task.setMechanic(this.mechanicService.findMechanicByFirstName(taskDto.getMechanic().getFirstName()));
                task.setCar(this.carService.findCarById(taskDto.getCar().getId()));
                task.setPart(this.partService.findPartById(taskDto.getPart().getId()));
                this.taskRepository.save(task);
                builder.append(String.format("Successfully imported car %.2f", task.getPrice())).append(System.lineSeparator());
            } else {
                builder.append("Invalid task").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
    StringBuilder builder=new StringBuilder();
        List<Task> allTasksWithTheirMechanicAndCar = findTaskWithCarAndMechanic();
        for (Task task : allTasksWithTheirMechanicAndCar) {
            builder.append(task.getCar().toString()).append(task.getMechanic().toString());
        }
        return builder.toString();
    }
    @Override
    public List<Task> findTaskWithCarAndMechanic() {
        return this.taskRepository.findTaskWithCarAndMechanic();
    }
}
