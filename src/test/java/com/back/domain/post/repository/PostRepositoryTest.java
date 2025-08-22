package com.back.domain.post.repository;

import com.back.domain.member.entity.Member;
import com.back.domain.member.repository.MemberRepository;
import com.back.domain.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;

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
        Member memberUser1 = memberRepository.findById(1).get();
        Post post = new Post(memberUser1, "제목 3", "내용 3");
        assertThat(post.getId()).isEqualTo(0);
        postRepository.save(post);
        assertThat(post.getId()).isGreaterThan(0);

        assertThat(post.getTitle()).isEqualTo("제목 3");
        assertThat(post.getContent()).isEqualTo("내용 3");
    }

    @Test
    @DisplayName("글 조회")
    void t3(){
        long count = postRepository.count();
        System.out.println(count);
        assertThat(count).isEqualTo(4);
    }
}
