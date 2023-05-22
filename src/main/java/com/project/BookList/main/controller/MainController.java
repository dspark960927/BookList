package com.project.BookList.main.controller;

;
import com.project.BookList.main.VO.MainVO;
import com.project.BookList.main.service.MainService;
import com.project.BookList.member.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    //메인페이지
    @RequestMapping("/main")
    public String Main(Model model, @SessionAttribute(name="memberVO",required = false)MemberVO memberVO){

        model.addAttribute("memberVO", memberVO);

        //신간
        List<MainVO> itemNew = new ArrayList<>();
        itemNew = mainService.getNewList();
        model.addAttribute("itemNew",itemNew);

        //베스트셀러
        List<MainVO> bestSeller = new ArrayList<>();
        bestSeller = mainService.getBestList();
        model.addAttribute("bestSeller",bestSeller);

        return "main";
    }

    //검색페이지
    @RequestMapping("/search")
    public String Search(@RequestParam("keyword") String keyword,
                         Model model,
                         @SessionAttribute(name="memberVO",required = false)MemberVO memberVO){
        List<MainVO> searchList = new ArrayList<>();
        searchList = mainService.getSearchList(keyword);
        model.addAttribute("searchList", searchList);

        return "search";
    }




}
