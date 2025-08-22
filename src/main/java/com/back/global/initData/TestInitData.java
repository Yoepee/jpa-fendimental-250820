package com.back.global.initData;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
@RequiredArgsConstructor
public class TestInitData {
    @Autowired
    @Lazy
    private TestInitData self;
    private final PostService postService;
    private final MemberService memberService;

    @Bean
    ApplicationRunner testInitDataApllicationRunner() {
        return args -> {
            self.work1();
        };
    }

    public void work1() {
        if (postService.count() >= 4) return;

        Member member = memberService.join("user1", "1234", "사용자 1");
        postService.write(member, "제목 1", "내용 1");
        postService.write(member, "제목 2", "내용 2");
        postService.write(member, "제목 3", "내용 3");
        postService.write(member, "제목 4", "내용 4");
    }
}
