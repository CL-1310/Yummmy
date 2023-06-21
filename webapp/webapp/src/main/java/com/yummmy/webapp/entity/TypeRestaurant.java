package com.yummmy.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "typerestaurant")

public class TypeRestaurant {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy="typeRestaurant")
    private List<Restaurant> restaurants;


}
