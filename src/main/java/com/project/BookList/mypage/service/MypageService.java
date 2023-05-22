package com.project.BookList.mypage.service;

import com.project.BookList.mypage.VO.MyLikeListVO;
import com.project.BookList.mypage.VO.MypageVO;

import java.util.List;

public interface MypageService {
    List<MypageVO> myLikelistSelect(int M_NO);

    MyLikeListVO getMyLikeList(int L_NO, String isbn);
}
