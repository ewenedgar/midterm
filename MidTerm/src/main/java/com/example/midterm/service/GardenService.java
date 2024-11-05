package com.example.midterm.service;

import com.example.midterm.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    //crud
    Optional<Garden> addNewGarden(Garden garden);
    Optional<Garden> updateGarden(Garden garden);
    List<Garden> getAllGardens();
    void removeGarden(Integer id);

}
