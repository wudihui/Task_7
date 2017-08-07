package com.how2java.service;

import com.how2java.pojo.Category;
import com.how2java.pojo.Register;

import java.util.List;

public interface CategoryService {

    int add(Category category);

    List<Category> getAll();

    List<Category> list();

    int getPpNumber();

    void register(Register register);

    Register getMP(String email);

    void setPortrait(String email,String protraitpath);

}
