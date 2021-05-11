package ru.javaops.bootjava;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.javaops.bootjava.restaurantvoting.model.Role;
import ru.javaops.bootjava.restaurantvoting.model.User;
import ru.javaops.bootjava.restaurantvoting.model.UserRepository;

import static org.hibernate.validator.internal.util.CollectionHelper.asSet;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("user@gmail.com", "User_First", "User_Last", "letmein", asSet(Role.ROLE_USER)));
        userRepository.save(new User("admin@gmail.com", "Admin_First", "Admin_Last", "letmein", asSet(Role.ROLE_ADMIN)));
    }
}
