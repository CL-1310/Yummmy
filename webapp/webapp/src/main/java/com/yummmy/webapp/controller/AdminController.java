package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.Contact;
import com.yummmy.webapp.entity.Dish;
import com.yummmy.webapp.entity.Restaurant;
import com.yummmy.webapp.entity.User;
import com.yummmy.webapp.service.ContactService;
import com.yummmy.webapp.service.DishService;
import com.yummmy.webapp.service.RestaurantService;
import com.yummmy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;


    //Afficher tous les restaurants

    @GetMapping("/admin/restaurants")
    public String restaurants( Model model){

        model.addAttribute("listRest", restaurantService.getRestaurants());
        return "pages/search";
    }

    //Afficher la page d'un restaurant

    @GetMapping("/admin/restaurants/detail/{id}")
    public String detailRestaurants(@PathVariable("id") int id, Model model){

        model.addAttribute("restaurant", restaurantService.getRestaurantById(id));
        //${restaurant.getNom()}
        return "pages/menu";
    }

    //Afficher la page d'ajout d'un restaurant

    @GetMapping("/admin/restaurateur")
    public String addRestaurant(){ return "pages/restaurant_registration";}


    //Ajouter les informations du restaurant dans la BDD

    @PostMapping("/admin/restaurateur")
    public String postRestaurant(Restaurant restaurant){
        restaurantService.saveRestaurant(restaurant);
        return "pages/restaurant_registration";
    }

    //Afficher l'espace restaurateur

    @GetMapping("/admin/espacerestaurateur")
    public String restaurateurArea(){ return "pages/restaurateur_area";}


    //Ajouter un plat

    @PostMapping("/admin/espacerestaurateur")
    public String addDish(Dish dish){
        dishService.saveDish(dish);
        return "pages/restaurateur_area";
    }

    //Mettre à jour un plat

    @PutMapping("/admin/espacerestaurateur")
    public String updateDish(Dish dish){
        dishService.saveDish(dish);
        return "pages/restaurateur_area";
    }

    //Supprimer un plat

//    @GetMapping("/admin/espacerestaurateur")
//    public String deleteDish(@RequestParam int idRest){
//        dishService.deleteDish(idRest);
//        return "pages/restaurateur_area";
//    }


    //Afficher la page d'inscription

    @GetMapping("/admin/register")
    public String getRegister(){
        return "pages/register";
    }

    //Ajouter un utilisateur

    @PostMapping("/admin/register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "pages/register";
    }

    //Afficher la page de contact

    @GetMapping("/admin/contact")
    public String getContact(){
        return "pages/contact";
    }

    //Envoyer le formulaire de contact

    @PostMapping("/admin/contact")
    public String postContact(Contact contact){
        contactService.saveContact(contact);
        return "pages/contact";
    }

    //Afficher la page login

    @GetMapping("/admin/login")
    public String getLogin(){
        return "pages/login";
    }

    //Afficher la page compte

    @GetMapping("/admin/account")
    public String getAccount(){
        return "pages/account";
    }
}
