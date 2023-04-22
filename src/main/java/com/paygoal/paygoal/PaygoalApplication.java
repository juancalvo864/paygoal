package com.paygoal.paygoal;

import com.paygoal.paygoal.models.Product;
import com.paygoal.paygoal.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaygoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaygoalApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository) {
		return (args) -> {

			Product vaso = new Product("Vaso","Vaso de plastico 500cc",12.00,50);
			Product plato = new Product("Plato","Plato de carton descartable",10.00,100);
			Product cubiertos = new Product("Cubiertos","Cubiertos descartables , alta resistencia",5.50,150);


			productRepository.save(vaso);
			productRepository.save(plato);
			productRepository.save(cubiertos);
		};
	}
}
