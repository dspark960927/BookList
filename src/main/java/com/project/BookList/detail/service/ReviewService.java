package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewVO;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    int reviewInsert(ReviewVO reviewVO);

    List<ReviewVO> reviewSelect(String bookKey);

    int reviewDelete(int R_ID);

    int reviewUpdate(ReviewVO reviewVO);


}
