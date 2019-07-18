package com.example.resource.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.resource.entity.Content;
import com.example.resource.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbContentController {

    @Autowired
    private ContentService ContentService;

    @GetMapping("/")
    public JSONObject selectAll(){
        JSONObject object =new JSONObject();
        List<Content> contentList = ContentService.selectAll();
        object.put("contentList",contentList);
        return object;
    }

    @GetMapping("/view/{id}")
    public JSONObject getById(@PathVariable("id")String id){
        JSONObject object =new JSONObject();
        Content content = ContentService.getById(id);
        object.put("content",content);
        return object;
    }
}
