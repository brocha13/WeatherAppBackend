package com.example.Pogoda.service;

import com.example.Pogoda.exceptions.UserExistsException;
import com.example.Pogoda.model.User;
import com.example.Pogoda.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean loginUser(User request){
        User user = repository.findByLogin(request.getLogin());

        return request.getLogin().equals(user.getLogin()) &&
                passwordEncoder.matches(request.getPassword(), user.getPassword());
    }

    public User registerNewUser(User user) {
        if (userExist(user.getLogin())) {
            throw new UserExistsException();
        }
        user.setActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User findUserByLogin(String login) throws IllegalArgumentException {
        if (userExist(login)) {
            return repository.findByLogin(login);
        }
        throw new IllegalArgumentException("User do not exists");
    }

    public boolean userExist(String login) {
        return repository.existsByLogin(login);
    }
}
