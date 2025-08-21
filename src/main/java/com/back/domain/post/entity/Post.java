package com.back.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // INT
    private String title; // VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private String content; // TEXT
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        createDate = LocalDateTime.now();
        modifyDate = LocalDateTime.now();
    }
}
