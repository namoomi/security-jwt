package com.example.security.app.entity;

import com.example.security.role.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String email, String pw, UserRole role){
        this.username = username;
        this.email = email;
        this.pw = pw;
        this.role = role;
    }
}
