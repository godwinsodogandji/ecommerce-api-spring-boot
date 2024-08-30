package bj.highfiveuniveristy.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import bj.highfiveuniveristy.ecommerce.models.User;
import bj.highfiveuniveristy.ecommerce.repositories.UserRepository;

@Service
public class DatabaseSeederService {
     @Autowired
     UserRepository userRepository;
     private final Faker faker = new Faker();

     public void seedDatabase() {
         for (int i = 0; i < 10; i++) {
             String username = faker.name().username();
            User user = User.builder()
                    .email(username+"@exemple.test")
                    .username(username)
                    .password(faker.internet().password())
                    .build();
            userRepository.save(user);
        }
    }
}
