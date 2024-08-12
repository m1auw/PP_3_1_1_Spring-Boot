package org.example.pp_3_1_1_springboot.service;

import org.example.pp_3_1_1_springboot.dao.UserRep;
import org.example.pp_3_1_1_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserRep userRep;

    @Autowired
    public UserServiceImp(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public void save(User user) {
        userRep.save(user);
    }

    @Override
    public void delete(Long id) {
        userRep.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRep.findAll();
    }
}
