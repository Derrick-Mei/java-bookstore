package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.User;

import java.util.List;

public interface UserService
{
    User save(User user);
    List<User> findAll();
    void delete(long id);
}