package com.yummmy.webapp.repository;

import com.yummmy.webapp.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DishRepository extends JpaRepository<Dish, Integer> {
    Dish findByName(String name);
}
