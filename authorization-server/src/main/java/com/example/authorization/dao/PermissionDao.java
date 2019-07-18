package com.example.authorization.dao;

import com.example.authorization.entity.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao extends BaseDao<Permission,String> {

    @Query(value = "SELECT P.* FROM tb_user AS u " +
            "LEFT JOIN tb_user_role AS ur ON u.id = ur.user_id " +
            "LEFT JOIN tb_role AS r ON r.id = ur.role_id " +
            "LEFT JOIN tb_role_permission AS rp ON r.id = rp.role_id " +
            "LEFT JOIN tb_permission AS P ON P.id = rp.permission_id  " +
            "WHERE u.id = :userId", nativeQuery = true)
    List<Permission> selectByUserId(@Param("userId") String userId);
}
