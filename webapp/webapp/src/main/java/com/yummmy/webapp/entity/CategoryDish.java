package com.yummmy.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorydish")

public class CategoryDish {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int position;

    @OneToMany(mappedBy="categoryDish")
    private List<Dish> dishes;

}
