package com.project.BookList.member.controller;

import com.project.BookList.member.VO.MemberVO;
import com.project.BookList.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/login")
    public String MemberLogin(){

        return "login";
    }



    @RequestMapping("/join")
    public String MemberInsertForm(@ModelAttribute MemberVO member){

        return "join";
    }

    @RequestMapping("/insertProc")
    public String MemberInsertProc(@ModelAttribute MemberVO member, HttpServletRequest request){
        System.out.println(member);

        memberService.memberInsert(member);

        return "join";
    }


    @RequestMapping("/findId")
    public String MemberFindId(){

        return "findId";
    }

    @RequestMapping("/findPw")
    public String MemberFindPw(){

        return "findPw";
    }
}
