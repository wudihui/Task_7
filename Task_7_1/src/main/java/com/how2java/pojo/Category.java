package com.how2java.pojo;

/**
 * Created by fanchen on 17-7-14.
 */
public class Category {
    private int id;
    private String magor;
    private String name;
    private String jianjie;
    private String portrait;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMagor() {
        return magor;
    }

    public void setMagor(String magor) {
        this.magor = magor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", magor='" + magor + '\'' +
                ", name='" + name + '\'' +
                ", jianjie='" + jianjie + '\'' +
                ", portrait='" + portrait + '\'' +
                '}';
    }
}
