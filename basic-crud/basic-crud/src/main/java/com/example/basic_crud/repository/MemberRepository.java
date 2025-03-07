package com.example.basic_crud.repository;

import com.example.basic_crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberName(String memberName);
    Optional<Member> findByNickname(String nickName);
    Optional<Member> findById(Long memberId);
    List<Member> findAll();
    void deleteById(Long id);
}