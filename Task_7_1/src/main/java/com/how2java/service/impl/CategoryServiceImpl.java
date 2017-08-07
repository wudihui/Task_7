package com.how2java.service.impl;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Register;
import com.how2java.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int add(Category category) {
        return 0;
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }

    @Override
    public List<Category> list(){
        return categoryMapper.list();
    }

    @Override
    public int getPpNumber() {
        return 0;
    }

    @Override
    public void register(Register register) {

    }

    @Override
    public Register getMP(String email) {
        return null;
    }

    @Override
    public void setPortrait(String email, String protraitpath) {

    }


}
