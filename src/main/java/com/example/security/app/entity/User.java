package com.example.security.app.entity;

import com.example.security.role.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Setter
    @Column(nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String email, String pw, UserRole role) {
        this.email = email;
        this.pw = pw;
        this.role = role;
    }
}
