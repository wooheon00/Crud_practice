package com.example.basic_crud.service;

import com.example.basic_crud.entity.Member;
import com.example.basic_crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void register(Member member){
        memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

    @Override
    public void deleteMemberById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public Optional<Member> findByMemberName(String memberName) {
        return memberRepository.findByMemberName(memberName);
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        return memberRepository.findByNickname(nickname);
    }

    @Override
    public Optional<Member> login(String memberName, String password) {
        Optional<Member> loginMember;
        loginMember = memberRepository.findByMemberName(memberName);

        if(loginMember.isEmpty()){
            return Optional.empty();
        }

        if(loginMember.get().getPassword().equals(password)){
            return loginMember;
        }else{
            return Optional.empty();
        }
    }


}
