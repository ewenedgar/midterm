package com.example.midterm.repository;

import com.example.midterm.model.Plant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    //List<Plant> findAll(Sort.by(Sort.Direction.ASC, "name"));

    Plant findByPlantId(Integer plantId);


    void deleteByPlantId(Integer id);

    //List<Plant> findByOrderByPlantDateASC();
}
