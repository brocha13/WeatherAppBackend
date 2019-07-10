package com.example.Pogoda.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    @NotEmpty(message = "*Please provide an login")
    private String login;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "active")
    private int active;

    public static class Builder{
        private User instance = new User();

        public Builder withLogin(String login){
            instance.login = login;
            return this;
        }

        public Builder withPassword(String password){
            instance.password = password;
            return this;
        }

        public Builder withActive(int active){
            instance.active = active;
            return this;
        }

        public User build(){
            return instance;
        }
    }
}
