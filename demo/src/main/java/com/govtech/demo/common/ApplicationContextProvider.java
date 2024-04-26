package com.govtech.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.govtech.demo.service.RestaurantService;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static RestaurantService restaurantService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }

    private static void setContext(ApplicationContext context) {
        ApplicationContextProvider.applicationContext = context;
    }

    public static <T extends Object> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    public static RestaurantService getRestaurantService() {
        if (restaurantService == null) {
            restaurantService = getBean(RestaurantService.class);
        }
        return restaurantService;
    }

}
