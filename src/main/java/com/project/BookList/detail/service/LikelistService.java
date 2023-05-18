package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.LikelistVO;
import com.project.BookList.detail.VO.ReviewVO;

import java.util.List;

public interface LikelistService {
    int likelistInsert(LikelistVO likelistVO);

    LikelistVO likkelistSelect(int M_NO, String L_BOOKKEY);

    int likelistDelete(int L_ID);
}
