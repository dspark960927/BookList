package com.project.BookList.member.controller;

import com.project.BookList.member.VO.MemberVO;
import com.project.BookList.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String MemberLoginPage(@ModelAttribute MemberVO member){
        return "login";
    }

    @PostMapping("/login")
    public String MemberLogin(MemberVO memberVO, HttpServletRequest req, RedirectAttributes rttr){
        //세션 생성
        HttpSession session = req.getSession();
        MemberVO member = memberService.memberLogin(memberVO);

        if(member == null){
            session.setAttribute("memberVO", null);
            rttr.addFlashAttribute("msg", false);
            System.out.println("1");

            return "redirect:/";
        }else{
            //로그인 성공하면 세션에 회원정보 보관
            session.setAttribute("memberVO", member);
            System.out.println("login" + member);
            System.out.println("로그인 성공");

            return "redirect:/main";
        }
    }

    @GetMapping("/join")
    public String MemberInsertForm(@ModelAttribute MemberVO member){

        return "join";
    }


    @PostMapping("/join")
    public String MemberInsertProc(@ModelAttribute MemberVO member, HttpServletRequest request){

        System.out.println(member);

        memberService.memberInsert(member);

        return "joinAccess";
    }


    /*
    @PostMapping("/join")
    public String MemberInsertProc(@Valid MemberVO member, BindingResult result, HttpServletRequest request){



        if (result.hasErrors()){
            System.out.println("!!");
            return "join";
        }

        System.out.println(member);

        memberService.memberInsert(member);

        return "joinAccess";
    }

     */


    @RequestMapping("/findId")
    public String MemberFindId(){

        return "findId";
    }

    @RequestMapping("/findPw")
    public String MemberFindPw(){

        return "findPw";
    }
}
