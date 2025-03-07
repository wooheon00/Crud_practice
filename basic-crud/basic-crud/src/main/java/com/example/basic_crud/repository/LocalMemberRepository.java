package com.example.basic_crud.repository;

import com.example.basic_crud.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/*
public class LocalMemberRepository implements MemberRepository{

    private final List<Member> members = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1); // ID 생성

    @Override
    public Member save(Member member) {
        member.setId(idGenerator.getAndIncrement());
        members.add(member);
        return member;
    }

    @Override
    public Optional<Member> findByMemberName(String memberName) {
        return members.stream()
                .filter(member -> member.getMemberName().equals(memberName))
                .findFirst();

    }

    @Override
    public Optional<Member> findById(Long memberId) {
        Optional<Member> member = Optional.empty();
        for(Member m : members){
            if(m.getId().equals(memberId)){
                member = Optional.of(m);
            }
        }
        return member;
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public void deleteByMemberName(String memberName) {
        members.removeIf(member -> member.getMemberName().equals(memberName));
    }

    @Override
    public void deleteById(Long id) {
        members.removeIf(member -> member.getId().equals(id));
    }
}


 */