package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskWrapperDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.models.entity.enums.CarType;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.repository.PartRepository;
import softuni.exam.repository.TaskRepository;
import softuni.exam.service.TaskService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.persistence.Enumerated;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private static final String TASK_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TaskRepository taskRepository;
@Enumerated()
    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final MechanicRepository mechanicRepository;

    private final CarRepository carRepository;

    private final PartRepository partRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, MechanicRepository mechanicRepository, CarRepository carRepository, PartRepository partRepository) {
        this.taskRepository = taskRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.mechanicRepository = mechanicRepository;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
    }

    @Override
    public boolean areImported() {
        return this.taskRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASK_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(TASK_FILE_PATH, TaskWrapperDTO.class)
                .getTasks()
                .stream()
                .filter(taskImportDTO -> {
                    boolean isValid = validationUtil.isValid(taskImportDTO);

                    Optional<Mechanic> byFirstName = mechanicRepository.findByFirstName(taskImportDTO.getName().getFirstName());

                    if (byFirstName.isEmpty()) isValid = false;

                    stringBuilder.append(isValid ? String.format("Successfully imported task %.2f", taskImportDTO.getPrice()) : "Invalid task").append(System.lineSeparator());

                    return isValid;
                })
                .map(taskImportDTO -> {
                    Task task = modelMapper.map(taskImportDTO, Task.class);
                    task.setCar(carRepository.findById(taskImportDTO.getCarId().getId()).get());
                    task.setMechanic(mechanicRepository.findByFirstName(taskImportDTO.getName().getFirstName()).get());
                    task.setPart(partRepository.findById(taskImportDTO.getPartId().getId()).get());
                    task.setDate(LocalDateTime.parse(taskImportDTO.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    return task;
                })
                .forEach(taskRepository::saveAndFlush);

        return stringBuilder.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Task> tasks = taskRepository.findAllByCar_CarTypeOrderByPriceDesc(CarType.coupe);

        for (Task task : tasks) {
            stringBuilder.append(String.format("Car %s %s with %dkm%n" + "-Mechanic: %s %s - task №%d%n" + "--Engine: %.1f%n" + "---Price: %.2f$%n",
                    task.getCar().getCarMake(),
                    task.getCar().getCarModel(),
                    task.getCar().getKilometers(),
                    task.getMechanic().getFirstName(),
                    task.getMechanic().getLastName(),
                    task.getId(),
                    task.getCar().getEngine(),
                    task.getPrice()));
        }

        return stringBuilder.toString();
    }
}
