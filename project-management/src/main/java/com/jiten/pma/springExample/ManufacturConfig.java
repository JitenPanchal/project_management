package com.jiten.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufacturConfig {
	
	@Bean
	public Car getCar() {
		return new Car(new Engine());
	}
}
