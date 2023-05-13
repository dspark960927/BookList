package com.project.BookList.main.controller;

;
import com.project.BookList.main.VO.MainVO;
import com.project.BookList.main.service.MainService;
import com.project.BookList.member.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MainService mainService;


    @RequestMapping("/main")
    public String Main(Model model, MemberVO memberVO){
        System.out.println(memberVO);
        //신간
        List<MainVO> itemNew = new ArrayList<>();
        itemNew = mainService.getNewList();
        model.addAttribute("itemNew",itemNew);

        //System.out.println(itemNew);

        //베스트셀러
        List<MainVO> bestSeller = new ArrayList<>();
        bestSeller = mainService.getBestList();
        model.addAttribute("bestSeller",bestSeller);

        //System.out.println(bestSeller);

        return "main";
    }

    @RequestMapping("/search")
    public String Search(@RequestParam("keyword") String keyword, Model model){
        System.out.println(keyword);

        List<MainVO> searchList = new ArrayList<>();
        searchList = mainService.getSearchList(keyword);
        model.addAttribute("searchList", searchList);

        return "search";
    }




}
