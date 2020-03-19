package com.example.service;

import com.example.dao.LoginLogRegistry;
import com.example.dao.UserRegistry;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private UserRegistry userRegistry;

    @Mock
    private LoginLogRegistry loginLogRegistry;

    @Spy
    @InjectMocks
    private UserService userService;

    @Test
    public void hasMatchUser() {
        doReturn(true)
                .when(userService)
                .hasMatchUser("admin", "123456");
        doReturn(false)
                .when(userService)
                .hasMatchUser("admin", "1111");
    }

    @Test
    public void findUserByUserName() {
        // target
        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword("123456");
        // test
        doReturn(admin)
                .when(userService)
                .findUserByUserName("admin");
    }

    @Test
    public void loginSuccess() {
        // data
        User user = new User();
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        // test
        doReturn(true)
                .when(userService)
                .saveLog(user);
    }
}

