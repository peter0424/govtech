package com.govtech.demo.service;

import java.util.List;

import com.govtech.demo.entity.Restaurant;

public interface RestaurantService {
    
    public void addRestaurant(String restaurantName);

    public String getRandomRestaurant();

    public List<Restaurant> getRestaurantList();

    public boolean existsByRestaurantName(String restaurantName);

}
