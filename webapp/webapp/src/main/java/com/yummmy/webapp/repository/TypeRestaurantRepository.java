package com.yummmy.webapp.repository;

import com.yummmy.webapp.entity.TypeRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeRestaurantRepository  extends JpaRepository<TypeRestaurant, Integer> {
    TypeRestaurant findByName(String name);
}
