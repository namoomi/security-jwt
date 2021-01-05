package com.example.security.repository;

import com.example.security.app.entity.User;
import com.example.security.app.repository.UserRepository;
import com.example.security.role.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest//모든 컨텍스트가 다올라간다
//@DataJpaTest
@Transactional
@Rollback(false)
@ActiveProfiles("local")
public class UserRepositoryTest {

    @Autowired
    private  UserRepository userRepository;

    @Test
    public void findByEmail() {
        User user = new User("connie2", "connie.2@projectvanilla.kr", "pwpw", UserRole.USER);
        userRepository.save(user);

        User data = userRepository.findByEmail("connie.2@projectvanilla.kr").get();
        System.out.println("username ::: "+data.getUsername());
    }
}
