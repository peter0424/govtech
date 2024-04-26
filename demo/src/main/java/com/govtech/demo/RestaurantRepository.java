package com.govtech.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.govtech.demo.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(value = "SELECT e FROM Restaurant e ORDER BY RAND() LIMIT 1")
    public Optional<Restaurant> findRandomRestaurant();

    public boolean existsByName(String name);

}
