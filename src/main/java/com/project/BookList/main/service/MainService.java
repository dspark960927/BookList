package com.project.BookList.main.service;

import com.project.BookList.main.VO.MainVO;

import java.util.List;

public interface MainService {

    List<MainVO> getNewList();
    List<MainVO> getBestList();
    List<MainVO> getSearchList(String keyword);
}
