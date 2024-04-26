package com.govtech.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.govtech.demo.RestaurantRepository;
import com.govtech.demo.entity.Restaurant;
import com.govtech.demo.exception.NoDataException;
import com.govtech.demo.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Override
    public void addRestaurant(String restaurantName) {
        repository.save(new Restaurant(restaurantName));
    }

    @Override
    public String getRandomRestaurant() {
        return repository.findRandomRestaurant().orElseThrow(NoDataException::new).getName();
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        return repository.findAll();
    }

    @Override
    public boolean existsByRestaurantName(String restaurantName) {
        return repository.existsByName(restaurantName);
    }

}
