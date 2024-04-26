package com.govtech.demo.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.govtech.demo.validation.NotExistsValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotExistsValidator.class)
public @interface NotExists {

    public String message() default "Record exists!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}