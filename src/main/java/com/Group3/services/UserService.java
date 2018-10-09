package com.Group3.services;

import com.Group3.domain.User;

import java.util.Optional;

public interface UserService {

    User create(User user);
    Optional<User> read(long id);
    User update(User user);
    void delete(User id);
    Iterable<User> findAllUsers();
    User findByName(String name);
}
