package com.live.conferencereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ConferenceReviewApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConferenceReviewApplication.class, args);
	}


	/*
	  public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	 */

}
