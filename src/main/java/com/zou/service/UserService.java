package com.zou.service;

import com.zou.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void insert(User user);
    void deleteById(Integer id);
    void updateById(User user);
    public List<User> findByExample(User user);
}
