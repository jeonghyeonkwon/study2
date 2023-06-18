package com.jeonghyeon.study.webapplication.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPwd;

    private String userName;

    private Integer age;

    protected User(){}

    public User(String userId,String userPwd,String userName,Integer age){
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.age = age;
    }

}
