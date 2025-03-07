package com.example.basic_crud.controller;

import com.example.basic_crud.entity.Comment;
import com.example.basic_crud.entity.Member;
import com.example.basic_crud.entity.Post;
import com.example.basic_crud.service.CommentService;
import com.example.basic_crud.service.MemberService;
import com.example.basic_crud.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public MemberController(MemberService memberService, PostService postService, CommentService commentService) {
        this.memberService = memberService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/members/{id}")
    public String getPostDetail(@PathVariable("id") Long id, Model model) {

        Long postCnt = 0L;
        Long commentCnt = 0L;

        for(Post post : postService.getAllPost()){
            if(post.getMember().getId().equals(id)) postCnt++;
        }

        for(Comment comment : commentService.findAll()){
            if(comment.getMember().getId().equals(id)) commentCnt++;
        }

        model.addAttribute("postCnt", postCnt);
        model.addAttribute("commentCnt", commentCnt);

        return "member-detail";
    }

    @GetMapping("/members/register")
    public String register() {
        return "member-register";
    }


    @PostMapping("/check/register")
    public String addMember(
            @RequestParam("memberName") String memberName,
            @RequestParam("password") String password,
            @RequestParam("nickname") String nickname,
            RedirectAttributes redirectAttributes) {



        if (memberService.findByMemberName(memberName).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "이미 존재하는 아이디입니다.");
            return "redirect:/members/register";
        }
        else if(memberService.findByNickname(nickname).isPresent())
        {
            redirectAttributes.addFlashAttribute("error", "이미 존재하는 닉네임입니다.");
            return "redirect:/members/register";
        }

        Member newMember = new Member(memberName, password, nickname);
        memberService.register(newMember);
        return "redirect:/main";
    }

    @GetMapping("/members/login")
    public String login() {
        return "member-login";
    }

    @PostMapping("/check/login")
    public String loginMember(
            @RequestParam("memberName") String memberName,
            @RequestParam("password") String password,
            Model model,
            RedirectAttributes redirectAttributes,
            HttpSession session) {

        Optional<Member> loginMember = memberService.login(memberName, password);

        if (loginMember.isPresent()) {
            session.setAttribute("member", loginMember.get());
            return "redirect:/main";
        } else {
            redirectAttributes.addFlashAttribute("error", "로그인 실패");
            return "redirect:/members/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }

    @PostMapping("/delete/member")
    public String deleteMember(
            HttpSession session,
            @RequestParam("id") Long id) {
        memberService.deleteMemberById(id);
        session.invalidate();
        return "redirect:/main";
    }


    @GetMapping("/debug/member")
    public String debugMember(Model model) {
        List<Member> members = memberService.getAllMember();
        model.addAttribute("members", members);
        return "debug-member";
    }


}
