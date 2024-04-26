package com.govtech.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.govtech.demo.entity.Restaurant;
import com.govtech.demo.service.RestaurantService;
import com.govtech.demo.validation.annotation.NotExists;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/v1/api/restaurant", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService service;

    @PostMapping("/add-restaurant")
    public void addRestaurant(@RequestBody @NotExists(message = "Restaurant name already exists!") String restaurantName) {
        service.addRestaurant(restaurantName);
    }

    @GetMapping("/get-random-restaurant")
    public String getRandomRestaurant() {
        return service.getRandomRestaurant();
    }

    @GetMapping("/get-restaurant-list")
    public List<Restaurant> getRestaurantList() {
        return service.getRestaurantList();
    }
}