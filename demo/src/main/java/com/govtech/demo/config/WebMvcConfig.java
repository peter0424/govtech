package com.govtech.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

	private final Environment env;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/**/{path:[^\\.]*}").setViewName("forward:/");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		if (!Arrays.asList(env.getActiveProfiles()).contains("prod")) {
			registry.addMapping("/**").allowedMethods("GET", "POST").allowedOrigins("http://localhost:4200");
		}
	}

}
