package com.jeonghyeon.study.webapplication.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userId;
    private String userName;
    private Integer age;

    public UserDto(Long id, String userId, String userName, Integer age) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }
}
