package com.example.service;

import com.example.dao.LoginLogRegistry;
import com.example.dao.UserRegistry;
import com.example.domain.LoginLog;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRegistry userDao;

    @Autowired
    private LoginLogRegistry loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        long matchCount = userDao.countByUserNameAndPassword(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Transactional
    public boolean saveLog(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.save(loginLog);
        return true;
    }
}
