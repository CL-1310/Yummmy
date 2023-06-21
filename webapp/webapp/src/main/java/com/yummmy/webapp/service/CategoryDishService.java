package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.CategoryDish;
import com.yummmy.webapp.repository.CategoryDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryDishService {

    @Autowired
    private CategoryDishRepository repository;

    //    AJOUTER UNE CATEGORIE DE PLAT

    public CategoryDish saveCategoryDish(CategoryDish categoryDish){

        return repository.save(categoryDish);
    }

    //    OBTENIR TOUTES LES CATEGORIES DE PLATS

    public List<CategoryDish> getCategoryDishes() {

        return repository.findAll();
    }

    //    OBTENIR UNE CATEGORIE DE PLAT PAR SON ID

    public CategoryDish getCategoryDishById(int id) {

        return repository.findById(id).orElse(null);
    }

    //    OBTENIR UNE CATEGORIE DE PLAT PAR SON NOM

    public CategoryDish getCategoryDishByName(String name) {

        return repository.findByName(name);
    }

    //    SUPPRIMER UNE CATEGORIE DE PLAT

    public String deleteCategoryDish(int id) {
        repository.deleteById(id);
        return "Catégorie de plat supprimée !"+id;
    }

    //    METTRE A JOUR UNE CATEGORIE DE PLAT

    public CategoryDish updateCategoryDish(CategoryDish categoryDish){
        CategoryDish existingCategoryDish=repository.findById(categoryDish.getId()).orElse(null);
        existingCategoryDish.setName(categoryDish.getName());
        return repository.save(existingCategoryDish);
    }
}
