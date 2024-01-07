package com.example.userservice.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 50)
    private String userId;
    @Column(nullable = false, unique = true)
    private String encryptedPwd;
    @Column(nullable = false, length = 20)
    private String name;

    @Builder
    public UserEntity(Integer id, String email, String userId, String encryptedPwd, String name) {
        this.id = id;
        this.email = email;
        this.userId = userId;
        this.encryptedPwd = encryptedPwd;
        this.name = name;
    }
}
