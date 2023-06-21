package com.yummmy.webapp.repository;

import com.yummmy.webapp.entity.LineOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LineOrderRepository extends JpaRepository<LineOrder, Integer> {

}
