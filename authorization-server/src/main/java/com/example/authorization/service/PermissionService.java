package com.example.authorization.service;


import com.example.authorization.entity.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> selectByUserId(String id);
}
