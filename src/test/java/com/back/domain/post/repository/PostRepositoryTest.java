package com.back.domain.post.repository;

import com.back.domain.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("2번글 조회")
    void t1(){
        Post post = postRepository.findById(2).get();

        assertThat(post.getTitle()).isEqualTo("제목 2");
        assertThat(post.getContent()).isEqualTo("내용 2");
    }

    @Test
    @DisplayName("글 생성")
    void t2() {
        Post post = postRepository.save(new Post("제목 3", "내용 3"));

        assertThat(post.getTitle()).isEqualTo("제목 3");
        assertThat(post.getContent()).isEqualTo("내용 3");
    }
}
