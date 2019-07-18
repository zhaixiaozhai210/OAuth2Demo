package com.example.resource.dao;

import com.example.resource.entity.Content;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao extends BaseDao<Content, String> {

    @Query(value = "select * from tb_content where id = :id", nativeQuery = true)
    Content findOneById(@Param("id") String id);
}
