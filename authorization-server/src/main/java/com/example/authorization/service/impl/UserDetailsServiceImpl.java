package com.example.authorization.service.impl;


import com.example.authorization.entity.Permission;
import com.example.authorization.entity.User;
import com.example.authorization.service.PermissionService;
import com.example.authorization.service.TBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    TBUserService userService;

    @Autowired
    PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user != null) {
            List<Permission> permissionList = permissionService.selectByUserId(user.getId());
            permissionList.forEach(permission -> {
                if (permission != null && permission.getEnName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnName());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        // 由框架完成认证工作
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);
    }
}
