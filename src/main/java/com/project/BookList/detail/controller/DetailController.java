package com.project.BookList.detail.controller;

import com.project.BookList.detail.VO.DetailVO;
import com.project.BookList.detail.service.DetailService;
import com.project.BookList.main.VO.MainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DetailController {

    @Autowired
    DetailService detailService;

    @RequestMapping("/detail")
    public String Datail(@RequestParam("isbn") String isbn, Model model){
        System.out.println(isbn);
        List<DetailVO> detail = new ArrayList<>();
        detail = detailService.getDetailList(isbn);
        model.addAttribute("detail",detail);

        System.out.println(detail);

        return "detail";
    }


}
