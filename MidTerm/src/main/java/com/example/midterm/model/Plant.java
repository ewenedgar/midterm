package com.example.midterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "plants")
@Data@AllArgsConstructor@NoArgsConstructor
public class Plant {
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer plantId;
    private String name;
    private String type;
    private LocalDate plantDate;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "garden_id")
    private Garden garden;



    public Plant(String name, String type, LocalDate plantDate){
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
    }
    public Plant(Integer id, String name, String type, LocalDate plantDate){
        this.plantId = id;
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
        //this.gardenId = gardenId;

    }
    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", plantDate=" + plantDate +
                ", garden=" + garden +
                '}';
    }
}
