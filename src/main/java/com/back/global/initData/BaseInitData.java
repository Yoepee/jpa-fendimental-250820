package com.back.global.initData;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
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
    private final MemberService memberService;

    @Bean
    ApplicationRunner baseInitDataApllicationRunner() {
        return args -> {
            self.work0();
            self.work1();
            self.work2();
            new Thread(() -> self.work3()).start();
            self.work4();
        };
    }

    @Transactional
    void work0() {
        if (memberService.count() > 0) return;

        memberService.join("user1", "1234", "사용자 1");
        memberService.join("user2", "1234", "사용자 2");
        memberService.join("user3", "1234", "사용자 3");
        memberService.join("user4", "1234", "사용자 4");
        memberService.join("user5", "1234", "사용자 5");
    }

    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        Member member = memberService.findById(1).get();

        postService.write(member, "제목 1", "내용 1");
        postService.write(member, "제목 2", "내용 2");
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost = postService.findById(1);

        Post post = opPost.get();
        System.out.println("post:" + post);
    }

    @Transactional
    void work3() {
        Optional<Post> opPost = postService.findById(1);
        Post post = opPost.get();

        postService.modify(post, "제목 1 수정", "내용 1 수정");

        if (true) throw new RuntimeException("work3에서 예외발생");

        Optional<Post> opPost2 = postService.findById(2);
        Post post2 = opPost2.get();

        postService.modify(post2, "제목 2 수정", "내용 2 수정");
    }

    @Transactional
    void work4() {
        Optional<Post> opPost = postService.findById(1);
        Post post = opPost.get();

        postService.modify(post, "제목 1 수정2", "내용 1 수정2");
    }
}
