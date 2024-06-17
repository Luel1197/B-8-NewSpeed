package com.example.newspeed.mvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

import com.example.newspeed.controller.UserController;
import com.example.newspeed.dto.SignUpRequestDto;
import com.example.newspeed.entity.User;
import com.example.newspeed.security.UserDetailsImpl;
import com.example.newspeed.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest(UserController.class)
class UserControllerTest {


    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    @DisplayName("회원가입 테스트")
    void test1() throws Exception {
        Long Id = 1L;
        String userId = "userid1231";
        String password = "hjk121666!";
        String userName = "손아엘";
        String email = "sonael121@naver.com";
        String intro = "나는손아엘";


        String body = objectMapper.writeValueAsString(SignUpRequestDto.builder().userId(userId).password(password).Username(userName).email(email).intro(intro).build());


        mvc.perform(post("/api/user//signup").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().)


    }
}
