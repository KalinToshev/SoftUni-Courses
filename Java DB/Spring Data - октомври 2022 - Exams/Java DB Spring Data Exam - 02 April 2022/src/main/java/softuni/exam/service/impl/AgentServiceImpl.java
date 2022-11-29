package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final AgentRepository agentRepository;

    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    private final TownRepository townRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentImportDTO[].class))
                .filter(agentImportDTO -> {
                    boolean isValid = validationUtil.isValid(agentImportDTO);

                    Optional<Town> optionalTown = townRepository.findByTownName(agentImportDTO.getTown());

                    if (optionalTown.isEmpty()) {
                        isValid = false;
                    }

                    Optional<Agent> agentOptional = agentRepository.findByFirstName(agentImportDTO.getFirstName());

                    if (agentOptional.isPresent()) {
                        isValid = false;
                    }

                    stringBuilder.append(isValid ? String.format("Successfully imported agent %s %s",
                            agentImportDTO.getFirstName(),
                            agentImportDTO.getLastName()) : "Invalid agent")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(agentImportDTO -> {
                    Agent agent = modelMapper.map(agentImportDTO, Agent.class);
                    agent.setTown(townRepository.findByTownName(agentImportDTO.getTown()).get());
                    return agent;
                })
                .forEach(agentRepository::saveAndFlush);

        return stringBuilder.toString();
    }
}
