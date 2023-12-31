package com.yummmy.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")

public class Contact {

    @Id
    @GeneratedValue
    private int id;
    private String surname;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;

}
