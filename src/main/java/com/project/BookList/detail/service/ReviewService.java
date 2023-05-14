package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewVO;

import java.util.List;

public interface ReviewService {
    int reviewInsert(ReviewVO reviewVO);

    List<ReviewVO> reviewSelect(String bookKey);
}
