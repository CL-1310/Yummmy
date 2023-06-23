package com.yummmy.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lineorder")

public class LineOrder {

    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    private float price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dish", referencedColumnName = "id")
    private Dish dish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    private Order order;

}
