package com.example.security.repository;

import com.example.security.app.entity.User;
import com.example.security.app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Profile("local")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByEmail() {
        User user = new User("connie2", "connie.2@projectvanilla.kr", "pwpw");
        userRepository.save(user);

        User data = userRepository.findByEmail("connie.2@projectvanilla.kr").get();
        System.out.println("username ::: "+data.getUsername());
    }
}
