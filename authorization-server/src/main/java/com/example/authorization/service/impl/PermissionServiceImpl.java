package com.example.authorization.service.impl;

import com.example.authorization.dao.PermissionDao;
import com.example.authorization.entity.Permission;
import com.example.authorization.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> selectByUserId(String id) {
        List<Permission> permissionList = permissionDao.selectByUserId(id);
        return permissionList;
    }
}
