package com.example.springprojects.Entities.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_emails")
public class UserEmails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "secret_code")
    private String secret_code;

    @Column(name = "subscription")
    private boolean subscription;

    @Override
    public String toString() {
        return "userEmails{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", secret_code='" + secret_code + '\'' +
                '}';
    }
}
