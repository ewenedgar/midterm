package com.example.midterm.service.impl;

import com.example.midterm.model.Plant;
import com.example.midterm.repository.PlantRepository;
import com.example.midterm.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {
@Autowired
    private PlantRepository plantRepository;
    @Override
    public Optional<Plant> addNewPlant(Plant plant) {
        Plant newPlant = new Plant(plant.getName(), plant.getType(), plant.getPlantDate());

        return Optional.of(plantRepository.save(newPlant));
    }

    @Override
    public List<Plant> getAllPlantsByName() {

        return plantRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Plant> getAllPlantsByDate() {
        return plantRepository.findAll(Sort.by("plantDate"));
    }

    @Override
    public void removePlant(Integer id) {
        plantRepository.deleteByPlantId(id);
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        Plant existingPlant = plantRepository.findByPlantId(plant.getPlantId());
        existingPlant.setPlantDate(plant.getPlantDate());
        existingPlant.setName(plant.getName());
        existingPlant.setGarden(plant.getGarden());
        existingPlant.setType(plant.getType());



        return Optional.of(plantRepository.save(existingPlant));
    }
}
