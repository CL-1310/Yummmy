package com.yummmy.webapp.service;


import com.yummmy.webapp.entity.Dish;
import com.yummmy.webapp.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DishService {

    @Autowired
    private DishRepository repository;

    //    AJOUTER UN PLAT

    public Dish saveDish(Dish dish){
        return repository.save(dish);
    }

    //    OBTENIR TOUS LES PLATS

    public List<Dish> getDishes(){
        return  repository.findAll();
    }

    //    OBTENIR UN PLAT PAR SON ID

    public Dish getDishById(int id){
        return repository.findById(id).orElse(null);
    }

    //    OBTENIR UN PLAT PAR SON NOM

    public Dish getDishByName(String name){
        return repository.findByName(name);
    }

    //    SUPPRIMER UN PLAT

    public String deleteDish(int id){
        repository.deleteById(id);
        return "Plat supprimé !"+id;
    }

    //    METTRE A JOUR UN PLAT

    public Dish updateDish(Dish dish){
        Dish existingDish=repository.findById(dish.getId()).orElse(null);
        existingDish.setName(dish.getName());
        existingDish.setPrice(dish.getPrice());
        return repository.save(existingDish);
    }


}
