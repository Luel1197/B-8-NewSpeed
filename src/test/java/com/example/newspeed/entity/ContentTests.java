package com.example.newspeed.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContentTests {
    private Content content;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("userId123", "password123", "손아엘", "sonael121@naver.com", "나는 손아엘");
        content = new Content();
        content.setUser(user);
        content.setContent("이건 테스트 컨텐츠");
        content.setCreatedDate(LocalDateTime.now());
        content.setUpdatedDate(LocalDateTime.now());
    }

    @Test
    @DisplayName("생성자 테스트")
    void testContentConstructorAndGetters() {
        assertEquals(user, content.getUser());
        assertEquals("이건 테스트 컨텐츠", content.getContent());
        assertNotNull(content.getCreatedDate());
        assertNotNull(content.getUpdatedDate());
        assertEquals(0, content.getLikes());
        assertTrue(content.getLikeList().isEmpty());
    }

    @Test
    @DisplayName("좋아요 테스트")
    void testAddLike() {
        Like like = new Like();
        content.addLike(like);

        assertEquals(1, content.getLikeList().size());
        assertEquals(1, content.getLikes());
        assertTrue(content.getLikeList().contains(like));
        assertEquals(content, like.getContent());
    }

    @Test
    @DisplayName("좋아요 삭제 테스트")
    void testRemoveLike() {
        Like like = new Like();
        content.addLike(like);
        content.removeLike(like);

        assertEquals(0, content.getLikeList().size());
        assertEquals(0, content.getLikes());
        assertFalse(content.getLikeList().contains(like));
        assertNull(like.getContent());
    }

    @Test
    @DisplayName("업데이트 테스트")
    void testSetContent() {
        String newContent = "이건 업데이트 컨텐츠 테스트";
        content.setContent(newContent);
        assertEquals(newContent, content.getContent());
    }

    @Test
    @DisplayName("생성자 업데이트 테스트")
    void testSetUser() {
        User newUser = new User("userId123", "password123", "손아엘", "sonael121@naver.com", "나는 손아엘");
        content.setUser(newUser);
        assertEquals(newUser, content.getUser());
    }

    @Test
    @DisplayName("생성일 테스트")
    void testSetCreatedDate() {
        LocalDateTime newCreatedDate = LocalDateTime.now().minusDays(1);
        content.setCreatedDate(newCreatedDate);
        assertEquals(newCreatedDate, content.getCreatedDate());
    }

    @Test
    @DisplayName("업데이트일 테스트")
    void testSetUpdatedDate() {
        LocalDateTime newUpdatedDate = LocalDateTime.now().minusDays(1);
        content.setUpdatedDate(newUpdatedDate);
        assertEquals(newUpdatedDate, content.getUpdatedDate());
    }
}
