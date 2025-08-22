package com.back.domain.member.service;

import com.back.domain.member.entity.Member;
import com.back.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public long count() {
        return memberRepository.count();
    }

    public Member join(String username, String password, String nickname) {
        Member member = new Member(username, encryptPassword(password), nickname);
        return memberRepository.save(member);
    }

    private String encryptPassword(String password) {
        String encryptedPassword = String.valueOf((password+"secret24").hashCode());
        return Base64.getEncoder().encodeToString((password+"salt").getBytes());
    }
}
