package com.example.security.app.service;

import com.example.security.app.dto.UserDetailsVO;
import com.example.security.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@AllArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return repository.findByEmail(email).map(
               u -> new UserDetailsVO(u, Collections.singleton(
                       new SimpleGrantedAuthority("USER")
               ))).orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
