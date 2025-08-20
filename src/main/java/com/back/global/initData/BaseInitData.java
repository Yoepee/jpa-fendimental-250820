package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApllicationRunner() {
        return args -> {
            if (postRepository.count() > 0) return;

            Post post = new Post();
            post.setTitle("제목 1");
            post.setContent("내용 1");
            postRepository.save(post);

            Post post2 = new Post();
            post.setTitle("제목 2");
            post.setContent("내용 2");
            postRepository.save(post2);

            // insert into posts (content,title,id) values (?,?,default)

            System.out.println("기본 데이터 초기화");
        };
    }
}
