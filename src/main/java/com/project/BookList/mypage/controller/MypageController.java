package com.project.BookList.mypage.controller;

import com.project.BookList.member.VO.MemberVO;
import com.project.BookList.mypage.VO.*;
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
        List<MyLikelistResultVO> myLikelist = new ArrayList<>();
        myLikelist = mypageService.myLikelistSelect(memberVO.getM_NO());

        List<MyLikeListVO> myLike = new ArrayList<>();

        for(int i=0;i<myLikelist.size();i++){
            MyLikeListVO like = new MyLikeListVO();
            like.setMyLikelistApiVO(mypageService.getMyLikeList(myLikelist.get(i).getL_NO(),myLikelist.get(i).getL_BOOKKEY()));

            System.out.println(like);
            myLike.add(like);
        }

        model.addAttribute("likelist", myLike);

        return "myLikeList";
    }

    @RequestMapping("myreview")
    public String MyReview(@SessionAttribute(name="memberVO",required = false) MemberVO memberVO, Model model){
        List<MyReviewResultVO> myReviewList = new ArrayList<>();
        myReviewList = mypageService.myReviewSelect(memberVO.getM_NO());

        List<MyReviewListVO> myReview = new ArrayList<>();

        for(int i=0;i<myReviewList.size();i++){
            MyReviewListVO review = new MyReviewListVO();
            review.setMyReviewVO(myReviewList.get(i));

            review.setMyReviewGetVO(mypageService.getMyReviewList(myReviewList.get(i).getR_NO(),myReviewList.get(i).getR_BOOKKEY()));

            myReview.add(review);
        }

        return "myReview";
    }
}
