package com.yummmy.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Builder
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


    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return email;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return true;
    }

}
