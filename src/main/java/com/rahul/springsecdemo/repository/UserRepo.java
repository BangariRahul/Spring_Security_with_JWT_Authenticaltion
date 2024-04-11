package com.rahul.springsecdemo.repository;

import com.rahul.springsecdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);
}
