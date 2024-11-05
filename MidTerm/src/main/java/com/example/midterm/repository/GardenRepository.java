package com.example.midterm.repository;

import com.example.midterm.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Integer> {
    Garden findByGardenId(Integer gardenId);

    void deleteByGardenId(Integer id);
}
