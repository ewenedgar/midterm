package com.example.midterm;

import com.example.midterm.model.Garden;
import com.example.midterm.model.Plant;
import com.example.midterm.repository.GardenRepository;
import com.example.midterm.repository.PlantRepository;
import com.example.midterm.service.GardenService;
import com.example.midterm.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MidTermApplication {
    @Autowired
    private GardenService gardenService;
    @Autowired
    private PlantService plantService;
@Autowired
    PlantRepository plantRepository;
@Autowired
    GardenRepository gardenRepository;

    public static void main(String[] args) {
        SpringApplication.run(MidTermApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.print(" Start of application");

            Garden garden1 = new Garden(1, "Vegetable Patch", 50.0);
            //gardenService.addNewGarden(garden1);
            garden1.setGardenId(1);
            garden1.setName("Vegetable Patch");
            garden1.setSize(50.0);
            gardenRepository.save(garden1);
            Garden garden2 = new Garden(2, "Herb Garden",20.0);
            garden2.setGardenId(2);
            garden2.setName("Herb Garden");
            garden2.setSize(20.0);
            //gardenService.addNewGarden(garden2);
            gardenRepository.save(garden2);

            System.out.println("Garden 1" + garden1);
            System.out.println("Garden 2" + garden2);

            LocalDate date1 = LocalDate.of(2024,3,10);
            Plant plant1;
            plant1 = new Plant(1,"Tomato","Vegetable",date1);

            LocalDate date2 = LocalDate.of(2024,2,20);
            Plant plant2;
            plant2 = new Plant(2, "Carrot","Vegetable",LocalDate.of(2024, 2,20));
            Plant plant3;
            plant3 = new Plant(3,"Basil", "Herb",LocalDate.of(2024,4,5));

            plant1.setGarden(garden1);
            plant2.setGarden(garden1);
            plant3.setGarden(garden2);
            plantRepository.save(plant1);
            plantRepository.save(plant2);
            plantRepository.save(plant3);

            System.out.println("Gardens Avaialble");
            List<Garden> gardens = gardenService.getAllGardens();
            gardens.forEach(System.out::println);
            //System.out.println(gardenService.getAllGardens());

            System.out.println("Plants Available order by Name");
            List<Plant> printPlant = plantService.getAllPlantsByName();
            printPlant.forEach(System.out::println);

            System.out.println("plants Available order by Date");
            List<Plant> printPlant1 = plantService.getAllPlantsByDate();
            printPlant1.forEach(System.out::println);


            //Addnew Plant
            Plant plant4 = new Plant();
            plant4.setPlantId(4);
            plant4.setName("RoseMary");
            plant4.setGarden(garden1);
            plantRepository.save(plant4);

            //Update plant
            Plant plant5 = new Plant();
            plant5 = plant1;

            plant5.setType("Fruit");

            //System.out.println(plantService.updatePlant(plant5));
             System.out.println("updating plant");

            //Delete Plant
            //plantService.removePlant(2);
            plantRepository.deleteByPlantId(2);
            List<Plant> plantDeleteList = plantService.getAllPlantsByName();
            plantDeleteList.forEach(System.out::println);






        };
    }
}
