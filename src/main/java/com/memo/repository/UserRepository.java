package com.memo.repository;

import com.memo.entity.User;

import java.util.List;

public interface UserRepository {

    public void save(User user);

    public User readById(String id);

    public List<User> readAll();
}
