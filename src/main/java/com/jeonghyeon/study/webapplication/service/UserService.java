package com.jeonghyeon.study.webapplication.service;

import com.jeonghyeon.study.webapplication.dto.UserDto;
import com.jeonghyeon.study.webapplication.entity.User;
import com.jeonghyeon.study.webapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/*
* transaction.start()
* 상품 테이블, 상품 옵션 테이블
* 상품 옵션 갯수가 5개 -> 3개 변경
* update 상품 옵션 테이블 데이터 건듬
*
* 오류
*
* update 상품 테이블 데이터 건듬
* commit
*
* 중간 에러가 터짐 -> rollback
* */


@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<UserDto> createInitUser(){

        List<User> initList = new ArrayList<>();
        Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
        random.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음

        List<String> nameRandom = new ArrayList<>();
        nameRandom.add("월요일");
        nameRandom.add("화요일");
        nameRandom.add("수요일");
        nameRandom.add("목요일");
        nameRandom.add("금요일");
        nameRandom.add("토요일");

        for(int i = 1;i<100;i++){
            User user = new User(
                    "유저" + i ,
                    "비밀번호 " + i,
                    "유저 이름 - " +nameRandom.get(random.nextInt(6)) + " 입니다",
                    random.nextInt(61)
            );
//            initList.add(user);
            userRepository.save(user);
        }
//        userRepository.saveAll(initList);
//    저장 끝

        //조회 시작
        List<User> response = userRepository.findAll();
//        List<UserDto> responseDto = response
//                                        .stream()
//                                        .map(obj ->
//                                                new UserDto(obj.getId(), obj.getUserPwd(), obj.getUserName(), obj.getAge()))
//                                        .collect(Collectors.toList());
        List<UserDto> responseDto = new ArrayList<>();
        for(int i = 0; i<response.size();i++){
            User user = response.get(i);
            UserDto dto = new UserDto(user.getId(),user.getUserId(),user.getUserName(),user.getAge());
            responseDto.add(dto);
        }

        return responseDto;
    }


    public UserDto findUser(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            User user = byId.get();
            return new UserDto(user.getId(), user.getUserId(),user.getUserName(),user.getAge());
        }
        return null;
    }
}
