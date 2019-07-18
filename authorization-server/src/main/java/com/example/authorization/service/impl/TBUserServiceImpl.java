package com.example.authorization.service.impl;

import com.example.authorization.dao.UserDao;
import com.example.authorization.entity.User;
import com.example.authorization.service.TBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TBUserServiceImpl implements TBUserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserName(String username) {
        User user = userDao.getUserByUserName(username);
        return user;
    }
}
