package com.example.security.services.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pw;

    public User(String username, String email, String pw){
        this.username = username;
        this.email = email;
        this.pw = pw;
    }
}
