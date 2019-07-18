package com.example.resource.service.impl;

import com.example.resource.dao.ContentDao;
import com.example.resource.entity.Content;
import com.example.resource.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentDao contentDao;

    @Override
    public Content getById(String id) {
        Content content = contentDao.findOneById(id);
        return content;
    }

    @Override
    public List<Content> selectAll() {
        return contentDao.findAll();
    }
}
