package com.example.dao;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRegistry extends JpaRepository<User, Integer> {

    @Query("select count(userId) from User where userName = :userName and password = :password")
    long countByUserNameAndPassword(
            @Param("userName") String userName,
            @Param("password") String password
    );

    User findByUserName(String userName);
}
