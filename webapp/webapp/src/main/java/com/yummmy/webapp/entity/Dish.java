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
@Table(name = "dish")

public class Dish {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float price;
    private int position;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category_dish", referencedColumnName = "id")
    private CategoryDish categoryDish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id")
    private Restaurant restaurant;

    @OneToMany(mappedBy="dish")
    private List<LineOrder> lineOrders;
}
