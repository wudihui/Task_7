package com.how2java.mapper;

import com.how2java.pojo.Category;
import com.how2java.pojo.Register;

import java.util.List;

public interface CategoryMapper {

    int add(Category category);

    List<Category> getAll();

    List<Category> list();

    Long getPpNumber();

    void register(Register register);

    Register getMP(String email);

    void setPortrait(Register register);

}