package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.Order;
import com.yummmy.webapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class OrderService {

    @Autowired
    private OrderRepository repository;

    //    AJOUTER UNE COMMANDE

    public Order saveOrder(Order order){
        return repository.save(order);
    }

    //    OBTENIR TOUTES LES COMMANDES

    public List<Order> getOrders(){
        return  repository.findAll();
    }

    //    OBTENIR UNE COMMANDE PAR SON ID

    public Order getOrderById(int id){
        return repository.findById(id).orElse(null);
    }

    //    SUPPRIMER UNE COMMANDE

    public String deleteOrder(int id){
        repository.deleteById(id);
        return "Commande supprimée !"+id;
    }

    //    METTRE A JOUR UNE COMMANDE

    public Order updateOrder(Order order){
        Order existingOrder=repository.findById(order.getId()).orElse(null);
        existingOrder.setPrice(order.getPrice());
        existingOrder.setDate(order.getDate());
        existingOrder.setStar(order.getStar());
        return repository.save(existingOrder);
    }
}
