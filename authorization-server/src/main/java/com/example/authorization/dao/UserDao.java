package com.example.authorization.dao;

import com.example.authorization.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User,String>{

    @Query(value = "select * from tb_user where username = :username",nativeQuery = true)
    User getUserByUserName(@Param("username") String username);
}
