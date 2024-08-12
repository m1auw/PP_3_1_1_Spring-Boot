package org.example.pp_3_1_1_springboot.service;

import org.example.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
