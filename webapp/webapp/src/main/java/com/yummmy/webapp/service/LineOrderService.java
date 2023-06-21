package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.LineOrder;
import com.yummmy.webapp.repository.LineOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LineOrderService {

    @Autowired
    private LineOrderRepository repository;

    //    AJOUTER UNE LIGNE DE COMMANDE

    public LineOrder saveLineOrder(LineOrder lineOrder){

        return repository.save(lineOrder);
    }

    //    OBTENIR TOUTES LES LIGNES DE COMMANDE

    public List<LineOrder> getLineOrders() {

        return repository.findAll();
    }

    //    OBTENIR UNE LIGNE DE COMMANDE PAR SON ID

    public LineOrder getLineOrderById(int id) {

        return repository.findById(id).orElse(null);
    }

    //    SUPPRIMER UNE LIGNE DE COMMANDE

    public String deleteLineOrder(int id) {
        repository.deleteById(id);
        return "Ligne de commande supprimée !"+id;
    }

    //    METTRE A JOUR UNE LIGNE DE COMMANDE

    public LineOrder updateLineOrder(LineOrder lineOrder){
        LineOrder existingLineOrder=repository.findById(lineOrder.getId()).orElse(null);
        existingLineOrder.setQuantity(lineOrder.getQuantity());
        existingLineOrder.setPrice(lineOrder.getPrice());
        return repository.save(existingLineOrder);
    }
}
