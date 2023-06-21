package com.yummmy.webapp.controller;


import com.yummmy.webapp.entity.CategoryDish;
import com.yummmy.webapp.service.CategoryDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryDishController {

    @Autowired
    private CategoryDishService service;

    //    AJOUTER UNE CATEGORIE DE PLAT

    @PostMapping("/addCategoryDish")
    public CategoryDish addCategoryDish(@RequestBody CategoryDish categoryDish) {
        return service.saveCategoryDish(categoryDish);
    }

    //    OBTENIR TOUTES LES CATEGORIES DE PLATS

    @GetMapping("/categoryDishes")
    public List<CategoryDish> findAllCategoryDishes() {
        return service.getCategoryDishes();
    }

    //    OBTENIR UNE CATEGORIE DE PLAT PAR SON ID

    @GetMapping("/categoryDish/{id}")
    public CategoryDish findCategoryDishById(@PathVariable int id){
        return service.getCategoryDishById(id);
    }

    //    OBTENIR UNE CATEGORIE DE PLAT PAR SON NOM

    @GetMapping("/categoryDish/{name}")
    public CategoryDish findCategoryDishByName(@PathVariable String name){
        return service.getCategoryDishByName(name);
    }

    //    METTRE A JOUR UNE CATEGORIE DE PLAT

    @PutMapping("/updatecategorydish")
    public CategoryDish updateCategoryDish(@RequestBody CategoryDish categoryDish){
        return service.updateCategoryDish(categoryDish);
    }

    //    SUPPRIMER UNE CATEGORIE DE PLAT

    @DeleteMapping("/deletecategorydish/{id}")
    public String deleteCategoryDish(@PathVariable int id){

        return service.deleteCategoryDish(id);
    }
}
