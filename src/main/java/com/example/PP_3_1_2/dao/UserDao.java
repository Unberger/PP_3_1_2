package com.example.PP_3_1_2.dao;


import org.springframework.stereotype.Component;
import com.example.PP_3_1_2.model.User;

import java.util.List;

@Component
public interface UserDao {

    List<User> showAllUsers ();

    User getUserById(int id);

    void save(User user);
    void update(int id, User user);
    void delete(int id);


}
