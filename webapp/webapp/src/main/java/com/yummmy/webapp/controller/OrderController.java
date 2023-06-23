package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.Order;
import com.yummmy.webapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class OrderController {

    @Autowired
    private OrderService service;

    //    AJOUTER UNE COMMANDE
    @PostMapping("/addOrder")
    public Order addDis(@RequestBody Order order){
        return service.saveOrder(order);
    }

    //    OBTENIR TOUTES LES COMMANDES

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return service.getOrders();
    }

    //    OBTENIR UNE COMMANDE PAR SON ID

    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }

    //    SUPPRIMER UNE COMMANDE

    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable int id){
        return service.deleteOrder(id);
    }

    //    METTRE A JOUR UNE COMMANDE

    @PutMapping("/updateorder")
    public Order updateOrder(@RequestBody Order order){
        return service.updateOrder(order);
    }


}
