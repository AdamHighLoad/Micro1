package com.akbcoffee.userservice.service;

import com.akbcoffee.userservice.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}