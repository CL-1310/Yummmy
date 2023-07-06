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
@Table(name = "restaurant")

public class Restaurant {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private int zipCode;
    private String city;
    private String phone;
    private String description;
    private String type;
    private String logo;
    private String image;

    private String duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type_restaurant", referencedColumnName = "id")
    private TypeRestaurant typeRestaurant;

    @OneToMany(mappedBy="restaurant")
    private List<Dish> dishes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy="restaurant")
    private List<Order> orders;


//    private float latitude;
//    private float longitude

}
