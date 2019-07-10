package com.example.Pogoda.repo;

import com.example.Pogoda.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);

    User findByLogin(String login);

    User save(User user);
}
