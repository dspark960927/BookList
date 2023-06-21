package com.project.BookList.detail.controller;

import com.project.BookList.detail.VO.*;
import com.project.BookList.detail.service.DetailService;
import com.project.BookList.detail.service.LikelistService;
import com.project.BookList.detail.service.ReviewService;
import com.project.BookList.member.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DetailController {

    @Autowired
    DetailService detailService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    LikelistService likelistService;

    //상세페이지 컨트롤러
    @GetMapping(value = "/detail",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String Detail(@RequestParam("isbn") String isbn, Model model,
                         @SessionAttribute(name="memberVO",required = false) MemberVO memberVO,
                         @ModelAttribute ReviewVO reviewVO,
                         ReviewPagingVO reviewPagingVO){

        List<DetailVO> detail = new ArrayList<>();
        detail = detailService.getDetailList(isbn);
        model.addAttribute("detail",detail);

        ReviewsVO reviews = new ReviewsVO();

        reviewPagingVO.setIsbn(isbn);
        reviews = reviewService.reviewList(reviewPagingVO,isbn);

        System.out.println(reviews);
        model.addAttribute("reviews",reviews);


        //List<ReviewPagingVO> reviewPaging = new ArrayList<>();
        //reviewPaging = reviewService.getReviewPaging(reviewPagingVO,isbn);


        //model.addAttribute("review", reviewService.reviewList(reviewPagingVO));

        //System.out.println(reviewService.reviewList(reviewPagingVO));


        /*
        List<ReviewVO> review = new ArrayList<>();
        review = reviewService.reviewSelect(isbn);
        model.addAttribute("review", review);

        model.addAttribute("member",memberVO);


        System.out.println(reviewPagingVO);

        List<ReviewVO> review = new ArrayList<>();
        review = reviewService.getReviewPaging(reviewPagingVO,isbn);
        model.addAttribute("review", review);

        System.out.println(review);
         */

        model.addAttribute("member",memberVO);

        if(memberVO != null){
            LikelistVO likelist = new LikelistVO();
            likelist = likelistService.likkelistSelect(memberVO.getM_NO(),isbn);

            model.addAttribute("likelist", likelist);

            int mChk = reviewService.reviewChkSelect(memberVO.getM_NO(),isbn);
            model.addAttribute("mChk",mChk);
        }

        return "detail";
    }

    @PostMapping("/detail")
    public String Review(@ModelAttribute ReviewVO reviewVO,
                         @SessionAttribute(name="memberVO",required = false) MemberVO memberVO,
                         @RequestParam("isbn") String isbn, RedirectAttributes re){

        re.addAttribute("isbn", isbn);

        reviewVO.setM_NO(memberVO.getM_NO());
        reviewVO.setR_BOOKKEY(isbn);

        reviewService.reviewInsert(reviewVO);

        return "redirect:/detail";
    }

    //한줄평 수정
    @PostMapping("/detail/update/R_NO/{R_NO}")
    @ResponseBody
    public void UpdateReview(ReviewVO reviewVO, Model model){
        reviewService.reviewUpdate(reviewVO);
    }

    //한줄평 삭제
    @PostMapping("/detail/delete/R_NO/{R_NO}")
    @ResponseBody
    public void ReviewDelete(@PathVariable int R_NO, @ModelAttribute ReviewVO reviewVO){
        reviewService.reviewDelete(R_NO);
    }

    //좋아요 추가
    @PostMapping("/detail/likeinsert/M_NO/{M_NO}")
    @ResponseBody
    public void LikelistInsert(@ModelAttribute LikelistVO likelistVO){
        likelistService.likelistInsert(likelistVO);
    }

    //좋아요 삭제
    @PostMapping("/detail/likedelete/L_NO/{L_NO}")
    @ResponseBody
    public void LikelistDelete(@PathVariable int L_NO){
        likelistService.likelistDelete(L_NO);
    }

}
