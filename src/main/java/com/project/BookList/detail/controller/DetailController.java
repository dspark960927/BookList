package com.project.BookList.detail.controller;

import com.project.BookList.detail.VO.DetailVO;
import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.service.DetailService;
import com.project.BookList.detail.service.ReviewService;
import com.project.BookList.member.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/detail")
    public String Datail(@RequestParam("isbn") String isbn, Model model, Model model2,
                         @SessionAttribute(name="memberVO",required = false) MemberVO memberVO,
                         @ModelAttribute ReviewVO reviewVO){

        //System.out.println("detail "+memberVO);
        //System.out.println(isbn);

        List<DetailVO> detail = new ArrayList<>();
        detail = detailService.getDetailList(isbn);
        model.addAttribute("detail",detail);

        //System.out.println(detail);

        List<ReviewVO> review = new ArrayList<>();
        review = reviewService.reviewSelect(isbn);
        model.addAttribute("review", review);

        model.addAttribute("member",memberVO);

        System.out.println(memberVO);
        System.out.println(review);

        //댓글 작성자
        if(memberVO != null){
            for(int i = 0;i < review.size();i++){
                if(review.get(i).getM_NO() == memberVO.getM_NO()){
                    model.addAttribute("isWriter",true);
                }
            }
        }
        return "detail";
    }

    @PostMapping("/detail")
    public String Review(@ModelAttribute ReviewVO reviewVO,
                         @SessionAttribute(name="memberVO",required = false) MemberVO memberVO,
                         @RequestParam("isbn") String isbn, RedirectAttributes re){

        re.addAttribute("isbn", isbn);

        System.out.println("post1 "+reviewVO);

        reviewVO.setM_NO(memberVO.getM_NO());
        reviewVO.setR_BOOKKEY(isbn);

        //reviewVO.setR_CONTS();

        reviewService.reviewInsert(reviewVO);

        System.out.println("post2 "+reviewVO);

        return "redirect:/detail";
    }

    /*
    @PostMapping("")
    @ResponseBody
    public UpdateReview(ReviewVO reviewVO, Model model){
        return;
    }

     */



    @PostMapping("/detail/delete/R_NO/{R_NO}")
    @ResponseBody
    public void ReviewDelete(@PathVariable int R_NO,
                               @ModelAttribute ReviewVO reviewVO
                               //,@RequestParam("isbn") String isbn, RedirectAttributes re
    ){

        System.out.println(R_NO);
        //re.addAttribute("isbn", isbn);

        reviewService.reviewDelete(R_NO);

        //return "redirect:/detail";
        //return "main";
    }
}
