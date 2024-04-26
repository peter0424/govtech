package com.govtech.demo.validation;

import com.govtech.demo.common.ApplicationContextProvider;
import com.govtech.demo.validation.annotation.NotExists;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotExistsValidator implements ConstraintValidator<NotExists, String> {

    public boolean isValid(String restaurantName, ConstraintValidatorContext cxt) {
        return !ApplicationContextProvider.getRestaurantService().existsByRestaurantName(restaurantName);
    }
}