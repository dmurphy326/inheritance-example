package com.dmurphy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dmurphy.parents.LivingBeing;

@SpringBootApplication
public class FunWithInheritanceApplication {
	private static final Logger log = LoggerFactory.getLogger(FunWithInheritanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FunWithInheritanceApplication.class, args);
		
		List<LivingBeing> list = FunWithInheritance.generateList();
		for(LivingBeing being: list) {
			log.info(being.toString());
		}
		
		FunWithInheritance.nature(list, 30);
		
		for(LivingBeing being: list) {
			log.info(being.toString());
		}
	}

}
