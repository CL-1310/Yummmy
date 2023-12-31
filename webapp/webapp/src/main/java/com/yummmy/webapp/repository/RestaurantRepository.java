package com.yummmy.webapp.repository;

import com.yummmy.webapp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findByName(String name);
}
