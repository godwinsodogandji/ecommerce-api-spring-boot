package bj.highfiveuniveristy.ecommerce;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.highfiveuniveristy.ecommerce.models.User;
import bj.highfiveuniveristy.ecommerce.repositories.UserRepository;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args)->{
			User johndoe= User.builder()
				.email("johndoe@gmail.com")
				.username("Jhon Doe")
				.password("123")
				.createdAt(LocalDateTime.now())
				.updatedAt(LocalDateTime.now())
					.build();
			userRepository.save(johndoe);
			User jhan = new User(null, "Jhan", "jhan@em.com", "eeeee", LocalDateTime.now(), LocalDateTime.now());
			userRepository.save(jhan);

		};
}
}