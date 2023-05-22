package com.project.BookList.mypage.service;

import com.project.BookList.mypage.VO.*;

import java.util.List;

public interface MypageService {
    List<MyLikelistResultVO> myLikelistSelect(int M_NO);

    MyLikelistApiVO getMyLikeList(int L_NO, String isbn);

    List<MyReviewResultVO> myReviewSelect(int M_NO);

    MyReviewApiVO getMyReviewList(int R_NO, String isbn);
}
