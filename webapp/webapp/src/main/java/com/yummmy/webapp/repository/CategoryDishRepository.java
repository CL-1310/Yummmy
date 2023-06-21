package com.yummmy.webapp.repository;

import com.yummmy.webapp.entity.CategoryDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryDishRepository extends JpaRepository<CategoryDish, Integer> {
    CategoryDish findByName(String name);
}
