package com.yummmy.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue
    private int id;
    private String surname;
    private String name;
    private String email;
    private String password;
    private String phone;
    private boolean restaurateur;

    @OneToMany(mappedBy="user")
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy="user")
    private List<Order> orders;


//    private String token;
//    private LocalDateTime dateUpdateToken;

}
