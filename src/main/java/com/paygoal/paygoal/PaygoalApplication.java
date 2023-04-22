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

			Product vaso = new Product("Vaso","Vaso de vidrio esfumado, alto impacto.",80.00,10);
			Product plato = new Product("Plato","Plato de ceramica, estilo cuadrado.",150.00,60);
			Product mantel = new Product ("Mantel","Mantel impermiable de facil limpieza, antideslisante.",350.00,8);

			productRepository.save(vaso);
			productRepository.save(plato);
			productRepository.save(mantel);


		};
	}

}
