package com.example.midterm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garden {
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Integer gardenId;
    private String name;
    private Double size;

    @OneToMany(mappedBy = "garden", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Plant> plantList;
        public Garden(Integer id, String name, Double size){
            this.gardenId = id;
            this.name = name;
            this.size = size;

        }
    @Override
    public String toString() {
        return "Garden{" +
                "name='" + name + '\'' +
                ", size=" + size +"m2"+
                //", plantList=" + plantList +
                '}';
    }
}
