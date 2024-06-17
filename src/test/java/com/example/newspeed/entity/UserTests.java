package com.example.newspeed.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.newspeed.status.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTests {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("userId123", "password123", "손아엘", "sonael121@naver.com", "나는 손아엘");
    }

    @Test
    @DisplayName("생성자 테스트")
    void testUserConstructor() {
        assertEquals("userId123", user.getUserId());
        assertEquals("password123", user.getPassword());
        assertEquals("손아엘", user.getUserName());
        assertEquals("sonael121@naver.com", user.getEmail());
        assertEquals("나는 손아엘", user.getIntro());
        assertEquals(UserStatus.ACTIVE, user.getStatus());
    }

    @Test
    @DisplayName("업뎃 유저 네임, 자기소개 테스트")
    void testUpdateUserNameAndIntro() {
        user.update("이아엘", "나는 이아엘");

        assertEquals("이아엘", user.getUserName());

        assertEquals("나는 이아엘", user.getIntro());
    }

    @Test
    @DisplayName("상태 변경 테스트")
    void testWithdrawnStatus() {

        user.withdhrawnStatus();

        assertEquals(UserStatus.WITHDRAWN, user.getStatus());
    }

    @Test
    @DisplayName("토큰 업뎃 테스트")
    void testUpdateToken() {
        String newToken = "newRefreshToken123";

        user.updateToken(newToken);

        assertEquals(newToken, user.getRefreshToken());
    }

    @Test
    @DisplayName("비번 변경 테스트")
    void testUpdatePassword() {

        String newPassword = "newPassword123";

        user.updatePassword(newPassword);

        assertEquals(newPassword, user.getPassword());
    }

}
