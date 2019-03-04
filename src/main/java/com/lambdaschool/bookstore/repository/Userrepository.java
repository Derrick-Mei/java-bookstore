package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
