package com.display.dateRange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:Message.properties")
public class DateAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateAppApplication.class, args);
	}

}
