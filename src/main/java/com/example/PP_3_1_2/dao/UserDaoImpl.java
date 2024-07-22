package com.example.PP_3_1_2.dao;

import org.springframework.stereotype.Repository;
import com.example.PP_3_1_2
        .model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> showAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(int id, User user) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        if (em.find(User.class, id) != null) {
            em.remove(getUserById(id));
        }
    }
}

