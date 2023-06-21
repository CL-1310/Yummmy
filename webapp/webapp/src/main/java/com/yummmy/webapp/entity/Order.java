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
@Table(name = "order")

public class Order {

    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime date;
    private float price;
    private int star;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id")
    private Restaurant restaurant;

    @OneToMany(mappedBy="order")
    private List<LineOrder> lineOrders;

}
