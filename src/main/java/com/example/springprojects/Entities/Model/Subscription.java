package com.example.springprojects.Entities.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "email")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "user_code")
    private String userCode;

    @Column(name = "subscription")
    private boolean subscription;

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", subscription=" + subscription +
                '}';
    }
}
