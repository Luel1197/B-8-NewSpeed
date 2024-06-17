package com.example.newspeed.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content news;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String comment;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Like> likeList = new ArrayList<>();

    public Comment(User user, String comment, Content news) {
        this.user = user;
        this.comment = comment;
        this.news = news;
    }

    public void addLike(Like like) {
        this.likeList.add(like);
        like.setComment(this);
    }

}
