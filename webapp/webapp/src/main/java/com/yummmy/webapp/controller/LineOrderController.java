package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.LineOrder;
import com.yummmy.webapp.service.LineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class LineOrderController {

    @Autowired
    private LineOrderService service;

    //    AJOUTER UNE LIGNE DE COMMANDE

    @PostMapping("/addLineOrder")
    public LineOrder addLineOrder(@RequestBody LineOrder lineOrder) {
        return service.saveLineOrder(lineOrder);
    }

    //    OBTENIR TOUTES LES LIGNES DE COMMANDE

    @GetMapping("/lineOrders")
    public List<LineOrder> findAllLineOrders() {
        return service.getLineOrders();
    }

    //    OBTENIR UNE LIGNE DE COMMANDE PAR SON ID

    @GetMapping("/lineOrder/{id}")
    public LineOrder findLineOrderById(@PathVariable int id){
        return service.getLineOrderById(id);
    }

    //    METTRE A JOUR UNE LIGNE DE COMMANDE

    @PutMapping("/updatelineorder")
    private LineOrder updateLineOrder(@RequestBody LineOrder lineOrder){
        return service.updateLineOrder(lineOrder);
    }

    //    SUPPRIMER UNE LIGNE DE COMMANDE

    @DeleteMapping("/deletelineorder/{id}")
    public String deleteLineOrder(@PathVariable int id){
        return service.deleteLineOrder(id);
    }

}
