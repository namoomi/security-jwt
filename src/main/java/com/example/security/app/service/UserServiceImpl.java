package com.example.security.app.service;
import com.example.security.app.entity.User;
import com.example.security.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
