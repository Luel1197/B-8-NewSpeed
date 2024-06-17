package com.example.newspeed.service;

import com.example.newspeed.dto.SignUpRequestDto;
import com.example.newspeed.entity.User;
import com.example.newspeed.repository.CommentRepository;
import com.example.newspeed.repository.ContentRepository;
import com.example.newspeed.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    ContentService contentService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ContentRepository contentRepository;

    User user;

    @Test
    @Order(1)
    @DisplayName("신규 유저 등록")
    void test1(){
        String userId = "userId12311";
        String password = "pasword12311";
        String name = "손아엘";
        String email = "sonael121@naver.com";
        String intro = "나는 손아엘";

        SignUpRequestDto requestDto = new SignUpRequestDto(userId, password, name, email, intro);

        user = userRepository.findById(1L).orElse(null);

    }

}
