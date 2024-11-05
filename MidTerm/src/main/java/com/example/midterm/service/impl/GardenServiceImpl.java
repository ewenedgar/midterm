package com.example.midterm.service.impl;

import com.example.midterm.model.Garden;
import com.example.midterm.repository.GardenRepository;
import com.example.midterm.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardenServiceImpl implements GardenService {
    @Autowired
    private GardenRepository gardenRepository;
    @Override
    public Optional<Garden> addNewGarden(Garden garden) {

        Garden newGarden = new Garden();
        newGarden.setName(garden.getName());
        newGarden.setSize(garden.getSize());
        return Optional.of(gardenRepository.save(newGarden));
    }

    @Override
    public Optional<Garden> updateGarden(Garden garden) {
        Garden existingGarden = gardenRepository.findByGardenId(garden.getGardenId());
        existingGarden.setName(garden.getName());
        existingGarden.setSize(garden.getSize());
        existingGarden.setPlantList(garden.getPlantList());
        return Optional.empty();
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepository.findAll();
    }

    @Override
    public void removeGarden(Integer id) {
        gardenRepository.deleteByGardenId(id);

    }
}
