package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApllicationRunner() {
        return args -> {
            if (postRepository.count() > 0) return;

            Post post = new Post("제목 1", "내용 1");
            postRepository.save(post);

            Post post2 = new Post("제목 2", "내용 2");
            postRepository.save(post2);

            // insert into posts (content,title,id) values (?,?,default)

            System.out.println("기본 데이터 초기화");

            Optional<Post> findPost = postRepository.findById(1);
        };
    }
}
