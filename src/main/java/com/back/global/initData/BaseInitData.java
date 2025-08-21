package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@AllArgsConstructor
@Configuration
public class BaseInitData {
    private PostService postService;

    @Bean
    ApplicationRunner baseInitDataApllicationRunner() {
        return args -> {
            work1();
            work2();
        };
    }

    void work1() {
        if (postService.count() > 0) return;

        postService.save(new Post("제목 1", "내용 1"));
        postService.save(new Post("제목 2", "내용 2"));
    }

    void work2() {
        Optional<Post> opPost = postService.findById(1);

        Post post = opPost.get();
        System.out.println(post.toString());
    }
}
