package com.yummmy.webapp.service;


import com.yummmy.webapp.entity.Restaurant;
import com.yummmy.webapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    //    AJOUTER UN RESTAURANT

    public Restaurant saveRestaurant(Restaurant restaurant){
        return repository.save(restaurant);
    }

    //    OBTENIR TOUS LES RESTAURANTS

    public List<Restaurant> getRestaurants() {
        return repository.findAll();
    }

    //    OBTENIR UN RESTAURANT PAR SON ID

    public Restaurant getRestaurantById(int id) {
        return repository.findById(id).orElse(null);
    }

    //    OBTENIR UN RESTAURANT PAR SON NOM

    public Restaurant getRestaurantByName(String name){
        return repository.findByName(name);
    }

    //    SUPPRIMER UN RESTAURANT

    public String deleteRestaurant(int id) {
        repository.deleteById(id);
        return "Restaurant supprimé !"+id;
    }

    //    METTRE A JOUR UN RESTAURANT

    public Restaurant updateRestaurant(Restaurant restaurant){
        Restaurant existingRestaurant=repository.findById(restaurant.getId()).orElse(null);
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setZipCode(restaurant.getZipCode());
        existingRestaurant.setCity(restaurant.getCity());
        existingRestaurant.setPhone(restaurant.getPhone());
        existingRestaurant.setDescription(restaurant.getDescription());
        existingRestaurant.setType(restaurant.getType());
        existingRestaurant.setLogo(restaurant.getLogo());
        existingRestaurant.setImage(restaurant.getImage());
        existingRestaurant.setDuration(restaurant.getDuration());
        return repository.save(existingRestaurant);
    }

}
