package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.TypeRestaurant;
import com.yummmy.webapp.repository.TypeRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TypeRestaurantService {

    @Autowired
    private TypeRestaurantRepository repository;

    //    AJOUTER UN TYPE DE RESTAURANT

    public TypeRestaurant saveTypeRestaurant(TypeRestaurant typeRestaurant){

        return repository.save(typeRestaurant);
    }

    //    OBTENIR TOUS LES TYPES DE RESTAURANTS

    public List<TypeRestaurant> getTypeRestaurants() {

        return repository.findAll();
    }

    //    OBTENIR UN TYPE DE RESTAURANT PAR SON ID

    public TypeRestaurant getTypeRestaurantById(int id) {

        return repository.findById(id).orElse(null);
    }

    //    OBTENIR UN TYPE DE RESTAURANT PAR SON NOM

    public TypeRestaurant getTypeRestaurantByName(String name) {

        return repository.findByName(name);
    }

    //    SUPPRIMER UN TYPE DE RESTAURANT

    public String deleteTypeRestaurant(int id) {
        repository.deleteById(id);
        return "Type de restaurant supprimé !"+id;
    }

    //    METTRE A JOUR UN TYPE DE RESTAURANT

    public TypeRestaurant updateTypeRestaurant(TypeRestaurant typeRestaurant){
        TypeRestaurant existingTypeRestaurant=repository.findById(typeRestaurant.getId()).orElse(null);
        existingTypeRestaurant.setName(typeRestaurant.getName());
        return repository.save(existingTypeRestaurant);
    }

}
