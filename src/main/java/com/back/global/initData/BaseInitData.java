package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Configuration
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;
    private final PostService postService;

    @Bean
    ApplicationRunner baseInitDataApllicationRunner() {
        return args -> {
            self.work1();
            self.work2();
        };
    }

    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        postService.save(new Post("제목 1", "내용 1"));
        postService.save(new Post("제목 2", "내용 2"));
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost = postService.findById(1);

        Post post = opPost.get();
        System.out.println("post:" + post);
    }
}
