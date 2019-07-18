package com.example.resource.service;

import com.example.resource.entity.Content;

import java.util.List;

public interface ContentService {

    /**
     * 根据 ID 获取
     *
     * @param id ID
     * @return {@link Content}
     */
    Content getById(String id);

    /**
     * 获取全部数据
     *
     * @return {@link List<Content>}
     */
    List<Content> selectAll();


}
