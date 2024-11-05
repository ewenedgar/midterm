package com.example.midterm.service;

import com.example.midterm.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    Optional<Plant>  addNewPlant(Plant plant);
    List<Plant>  getAllPlantsByName();
List<Plant> getAllPlantsByDate();
    void removePlant(Integer id);
    Optional<Plant> updatePlant(Plant plant);
}
