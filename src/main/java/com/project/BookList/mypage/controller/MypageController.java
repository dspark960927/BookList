package com.project.BookList.mypage.controller;

import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.service.ReviewService;
import com.project.BookList.member.VO.MemberVO;
import com.project.BookList.mypage.VO.*;
import com.project.BookList.mypage.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MypageController {
    @Autowired
    MypageService mypageService;

    @Autowired
    ReviewService reviewService;

    @RequestMapping("/mylikelist")
    public String MyLikeList(@SessionAttribute(name="memberVO",required = false) MemberVO memberVO, Model model) {
        List<MyLikelistResultVO> myLikelist = new ArrayList<>();
        myLikelist = mypageService.myLikelistSelect(memberVO.getM_NO());

        List<MyLikeListVO> myLike = new ArrayList<>();

        for(int i=0;i<myLikelist.size();i++){
            MyLikeListVO like = new MyLikeListVO();
            like.setMyLikelistApiVO(mypageService.getMyLikeList(myLikelist.get(i).getL_NO(),myLikelist.get(i).getL_BOOKKEY()));

            myLike.add(like);
        }
        model.addAttribute("likelist", myLike);

        return "myLikeList";
    }

    @RequestMapping("/myreview")
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

        model.addAttribute("review",myReview);

        return "myReview";
    }

    @RequestMapping("/myreviewupdatepop")
    public String MyReviewUpdatePop(@SessionAttribute(name="memberVO",required = false) MemberVO memberVO, Model model,
                                 @ModelAttribute ReviewVO reviewVO,
                                 @RequestParam("R_NO") String R_NO,
                                 @RequestParam("R_BOOKKEY") String R_BOOKKEY){
        MyReviewApiVO myReviewApi = new MyReviewApiVO();
        myReviewApi = mypageService.getMyReviewUpdate(R_BOOKKEY);

        model.addAttribute("myReviewApi", myReviewApi);

        System.out.println(myReviewApi);
        return "MyReviewUpdate";
    }

    @PostMapping("/myreviewupdate/R_NO/{R_NO}")
    @ResponseBody
    public void MyReviewUpdate(@SessionAttribute(name="memberVO",required = false) MemberVO memberVO,
                               @ModelAttribute ReviewVO reviewVO){
        reviewService.reviewUpdate(reviewVO);
    }
}
