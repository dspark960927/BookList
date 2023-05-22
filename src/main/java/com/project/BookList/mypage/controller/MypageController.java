package com.project.BookList.mypage.controller;

import com.project.BookList.member.VO.MemberVO;
import com.project.BookList.mypage.VO.MyLikeListVO;
import com.project.BookList.mypage.VO.MyLikeVO;
import com.project.BookList.mypage.VO.MypageVO;
import com.project.BookList.mypage.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MypageController {
    @Autowired
    MypageService mypageService;

    @RequestMapping("/mylikelist")
    public String MyLikeList(@SessionAttribute(name="memberVO",required = false) MemberVO memberVO, Model model) {
        List<MypageVO> myLikelist = new ArrayList<>();
        myLikelist = mypageService.myLikelistSelect(memberVO.getM_NO());

        List<MyLikeVO> myLike = new ArrayList<>();

        for(int i=0;i<myLikelist.size();i++){
            MyLikeVO like = new MyLikeVO();
            like.setMyLikeListVO(mypageService.getMyLikeList(myLikelist.get(i).getL_NO(),myLikelist.get(i).getL_BOOKKEY()));

            System.out.println(like);
            myLike.add(like);
        }
        System.out.println(myLike);

        model.addAttribute("likelist", myLike);

        return "myLikeList";
    }
}
