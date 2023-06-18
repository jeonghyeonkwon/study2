package com.jeonghyeon.study.webapplication.controller;

import com.jeonghyeon.study.webapplication.dto.UserDto;
import com.jeonghyeon.study.webapplication.entity.User;
import com.jeonghyeon.study.webapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    // controller -> service -> repository
    @Autowired
    private UserService userService;

    @GetMapping("/init")
    public ResponseEntity createInit(){
        List<UserDto> initUser = userService.createInitUser();
        return new ResponseEntity(initUser,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findUser(@PathVariable Long id){
        UserDto dto = userService.findUser(id);
        return new ResponseEntity(dto,HttpStatus.OK);
    }



    @GetMapping({"","/"})
    public ResponseEntity userList(){
        return null;
    }

}
