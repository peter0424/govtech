package com.govtech.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.govtech.demo.controller.RestaurantController;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {

	@Autowired
	private RestaurantController controller;

	@LocalServerPort
	private int port;

	@Autowired
	private MockMvc mockMvc;

	private static final String URL_ADD_RESTAURANT = "/add-restaurant";
	private static final String URL_LIST_RESTAURANT = "/get-restaurant-list";
	private static final String URL_GET_RANDOM_RESTAURANT = "/get-random-restaurant";

	@Test
	@Order(1)
	void contextLoads() {
		log.info("running contextLoads");
		Assertions.assertThat(controller).isNotNull();
	}

	@Test
	@Order(2)
	void defaultDataShouldBeLoaded() throws Exception {
		log.info("running defaultDataShouldBeLoaded");
		mockMvc.perform(get(getBaseUrl() + URL_GET_RANDOM_RESTAURANT, String.class)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(Matchers.notNullValue()));
	}

	@Test
	@Order(3)
	void addNewRestaurant() throws Exception {
		log.info("running addNewRestaurant");
		final String newRestaurant = "Texas Chicken";
		mockMvc.perform(
				post(getBaseUrl() + URL_ADD_RESTAURANT).contentType(MediaType.TEXT_PLAIN).content(newRestaurant))
				.andDo(print()).andExpect(status().isOk());
		mockMvc.perform(get(getBaseUrl() + URL_LIST_RESTAURANT)).andDo(print())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[?(@.name == '" + newRestaurant + "')]").exists());
	}

	private String getBaseUrl() {
		return "http://localhost:" + port + "/v1/api/restaurant";
	}

}
