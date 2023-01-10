package com.jailson.learningspringboot.dao;

import com.jailson.learningspringboot.model.User;

import java.util.*;

public class FakeDataDao implements UserDao {


    private static Map<UUID, User> database;

    static {
        database = new HashMap<>();
        UUID joeUserUid = UUID.randomUUID();
        String firstName = "Joe";
        String lastName = "Jones";
        Integer age = 22;
        String email = "joejones@gmail.com";
        database.put(joeUserUid, new User(joeUserUid, firstName, lastName, User.Gender.MALE, age, email));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public User getUser(UUID userUid) {
        return database.get(userUid);
    }

    @Override
    public int updateUser(User user) {
        database.put(user.getUserUid(), user);
        return 1;
    }

    @Override
    public int removeUser(UUID userUid) {
        database.remove(userUid);
        return 1;
    }

    @Override
    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user);
        return 1;
    }
}
