package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewPageVO;
import com.project.BookList.detail.VO.ReviewPagingVO;
import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.VO.ReviewsVO;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    int reviewInsert(ReviewVO reviewVO);

    List<ReviewVO> reviewSelect(String bookKey);

    int reviewDelete(int R_ID);

    int reviewUpdate(ReviewVO reviewVO);

    int reviewChkSelect(int M_NO, String isbn);

    //List<ReviewVO> getReviewPaging(ReviewPagingVO reviewPagingVO, String bookKey);

    //ReviewPageVO getReviewPage(ReviewPagingVO reviewPagingVO, int total);

    ReviewsVO reviewList(ReviewPagingVO reviewPagingVO, String isbn);

}
