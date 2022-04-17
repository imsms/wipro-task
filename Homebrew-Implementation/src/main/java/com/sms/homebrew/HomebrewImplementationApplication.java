package com.sms.homebrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class HomebrewImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebrewImplementationApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder().baseUrl(Constant.GATEWAY_URL);
	}
}
