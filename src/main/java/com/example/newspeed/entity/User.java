package com.example.newspeed.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String intro;

    @Column(nullable = false)
    private String status;

    private String refreshToken;

    @JoinColumn(name = "")
    @OneToMany
    private List<Content>contentList = new ArrayList<>();

    public void update(String name, String email, String intro) {
        this.name = name;
        this.email = email;
        this.intro = intro;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
