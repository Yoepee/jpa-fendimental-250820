package com.back.domain.post.service;

import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public long count() {
        return postRepository.count();
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
    }

    public Post write(Member author, String title, String content) {
        Post post = new Post(author, title, content);
        return postRepository.save(post);
    }
}
