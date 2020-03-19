package com.example.dao;


import com.example.config.JpaConfig;
import com.example.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.*;

@ContextConfiguration(classes = JpaConfig.class)
public class UserDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserRegistry userRegistry;

    @Test
    public void hasMatchUser() {
        long count = userRegistry.countByUserNameAndPassword("admin", "123456");
        assertTrue(count > 0);
    }

    @Test
    public void findUserByUserName() {
        User user = userRegistry.findByUserName("admin");
        assertNotNull(user);
        assertEquals(user.getUserName(), "admin");
    }

}
