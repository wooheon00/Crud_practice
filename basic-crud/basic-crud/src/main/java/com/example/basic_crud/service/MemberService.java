package com.example.basic_crud.service;

import com.example.basic_crud.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void register(Member member);
    List<Member> getAllMember();

    void deleteMemberById(Long memberId);

    Optional<Member> findByMemberName(String memberName);
    Optional<Member> findByNickname(String nickname);

    Optional<Member> login(String memberName, String password);



}
