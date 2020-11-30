package com.example.bakerythree;

import com.example.bakerythree.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BakerythreeApplication {

	@Autowired
	private BreadRepository breadRepository;

	@Autowired
	private TypeRepository typeRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(BakerythreeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Add Type objects and save to db
			Type t1 = new Type("Ruis");
			Type t2 = new Type("Kaura");
			Type t3 = new Type("Vehna");
			Type t4 = new Type("Gluten-Free");
			typeRepository.save(t1);
			typeRepository.save(t2);
			typeRepository.save(t3);
			typeRepository.save(t4);
			//add bread objects
			Bread b1 = new Bread("Ruismies","Fazer",0.45, 5,t1);
			Bread b2 = new Bread("Kauratyynyt", "Vaasan", 1.39, 4, t2);
			//save breads to breadRepository
			breadRepository.save(b1);
			breadRepository.save(b2);





		};
	}
}
