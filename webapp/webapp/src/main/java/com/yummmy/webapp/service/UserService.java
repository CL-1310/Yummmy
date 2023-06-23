package com.yummmy.webapp.service;

import com.yummmy.webapp.entity.User;
import com.yummmy.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    //    OBTENIR UN UTILISATEUR PAR SON EMAIL


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


}
