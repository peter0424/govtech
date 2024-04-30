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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@OpenAPIDefinition
@RestController
@RequestMapping(value = "/v1/api/restaurant", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService service;

    /**
     * add new restaurant
     */
    @Operation(summary = "Add new restaurant")
    @PostMapping("/add-restaurant")
    public void addRestaurant(@RequestBody @NotExists(message = "Restaurant name already exists!") String restaurantName) {
        service.addRestaurant(restaurantName);
    }

    /**
     * Get a random restaurant
     */
    @Operation(summary = "Get a random restaurant")
    @GetMapping("/get-random-restaurant")
    public String getRandomRestaurant() {
        return service.getRandomRestaurant();
    }

    /**
     * Get restaurant list
     */
    @Operation(summary = "List all restaurant")
    @GetMapping("/get-restaurant-list")
    public List<Restaurant> getRestaurantList() {
        return service.getRestaurantList();
    }
}