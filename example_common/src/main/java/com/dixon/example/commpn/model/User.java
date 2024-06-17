package com.dixon.example.commpn.model;

import java.io.Serializable;

/**
 * @Author: PanYa
 * @Date 2024/6/17-下午9:15
 * @Description: 用户
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
