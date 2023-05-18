package com.project.BookList.detail.controller;

import com.project.BookList.detail.VO.DetailVO;
import com.project.BookList.detail.VO.LikelistVO;
import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.service.DetailService;
import com.project.BookList.detail.service.LikelistService;
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

    @Autowired
    LikelistService likelistService;

    @GetMapping("/detail")
    public String Datail(@RequestParam("isbn") String isbn, Model model,
                         @SessionAttribute(name="memberVO",required = false) MemberVO memberVO,
                         @ModelAttribute ReviewVO reviewVO){

        List<DetailVO> detail = new ArrayList<>();
        detail = detailService.getDetailList(isbn);
        model.addAttribute("detail",detail);

        List<ReviewVO> review = new ArrayList<>();
        review = reviewService.reviewSelect(isbn);
        model.addAttribute("review", review);

        model.addAttribute("member",memberVO);

        if(memberVO != null){
            LikelistVO likelist = new LikelistVO();
            likelist = likelistService.likkelistSelect(memberVO.getM_NO(),isbn);

            model.addAttribute("likelist", likelist);
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

    @PostMapping("/detail/update/R_NO/{R_NO}")
    @ResponseBody
    public void UpdateReview(ReviewVO reviewVO, Model model){
        reviewService.reviewUpdate(reviewVO);
    }

    @PostMapping("/detail/delete/R_NO/{R_NO}")
    @ResponseBody
    public void ReviewDelete(@PathVariable int R_NO, @ModelAttribute ReviewVO reviewVO){
        reviewService.reviewDelete(R_NO);
    }

    @PostMapping("/detail/likeinsert/M_NO/{M_NO}")
    @ResponseBody
    public void LikelistInsert(@ModelAttribute LikelistVO likelistVO){

        likelistService.likelistInsert(likelistVO);
    }

    @PostMapping("/detail/likedelete/L_NO/{L_NO}")
    @ResponseBody
    public void LikelistDelete(@PathVariable int L_NO){
        likelistService.likelistDelete(L_NO);
    }

}
