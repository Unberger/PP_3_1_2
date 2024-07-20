package com.example.PP_3_1_2.service;

import com.example.PP_3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers ();

    User getUserById(int id);

    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
