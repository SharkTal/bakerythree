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
	private UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(BakerythreeApplication.class, args);
	}


}
