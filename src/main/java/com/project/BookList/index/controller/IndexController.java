package com.project.BookList.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";

    }

    @RequestMapping("/index1")
    public String index1(){
        return "index1";

    }

    @RequestMapping("/index2")
    public String index2(){
        return "index2";

    }

}
