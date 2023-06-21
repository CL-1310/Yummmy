package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.User;
import com.yummmy.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //    AJOUTER UN UTILISATEUR

    public User saveUser(User user) {
        return repository.save(user);
    }

    //    OBTENIR UN UTILISATEUR PAR SON ID

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    //    OBTENIR UN UTILISATEUR PAR SON NOM

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    //    SUPPRIMER UN UTILISATEUR

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "Utilisateur supprimé !"+id;
    }

    // METTRE A JOUR UN UTILISATEUR

    public User updateUser(User user) {
        User existingUser=repository.findById(user.getId()).orElse(null);
        existingUser.setSurname(user.getSurname());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        existingUser.setRestaurateur(user.isRestaurateur());
        return repository.save(existingUser);
    }

    public User registerUser(String email, String password, String surname, String name, String phone, boolean restaurateur) {
        if(email == null || password == null) {
            return null;
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setSurname(surname);
            user.setName(name);
            user.setPhone(phone);
            user.setRestaurateur(restaurateur);
            return repository.save(user);
        }
    }

    public User authenticate(String email, String password) {
        return repository.findByEmailAndPassword(email, password).orElse(null);
    }

}
