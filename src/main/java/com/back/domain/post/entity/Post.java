package com.back.domain.post.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
@ToString
public class Post extends BaseEntity {
    private String title; // VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private String content; // TEXT

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
