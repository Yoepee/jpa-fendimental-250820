package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public void save(Post post) {
        postRepository.save(post);
    }

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public long count() {
        return postRepository.count();
    }
}
