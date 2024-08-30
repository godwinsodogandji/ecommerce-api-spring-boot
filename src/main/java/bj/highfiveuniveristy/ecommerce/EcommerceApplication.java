package bj.highfiveuniveristy.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.highfiveuniveristy.ecommerce.services.DatabaseSeederService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DatabaseSeederService databaseSeederService) {
		return (args) -> {
			databaseSeederService.seedDatabase();
		};
	}
}