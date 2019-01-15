package com.thangtm.menuportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MenuPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuPortalApplication.class, args);
	}

}

