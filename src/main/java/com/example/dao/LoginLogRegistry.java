package com.example.dao;

import com.example.domain.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRegistry extends JpaRepository<LoginLog, Integer> {

    LoginLog save(LoginLog loginLog);

}
