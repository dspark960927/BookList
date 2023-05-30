package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewPageVO;
import com.project.BookList.detail.VO.ReviewPagingVO;
import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.VO.ReviewsVO;
import com.project.BookList.detail.mapper.ReviewMapper;
import org.hibernate.validator.internal.engine.PredefinedScopeConfigurationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public int reviewInsert(ReviewVO reviewVO) {
        return reviewMapper.ReviewInsert(reviewVO);
    }

    @Override
    public List<ReviewVO> reviewSelect(String bookKey) {
        return reviewMapper.reviewSelect(bookKey);
    }

    @Override
    public int reviewDelete(int R_ID) {
        return reviewMapper.reviewDelete(R_ID);
    }

    @Override
    public int reviewUpdate(ReviewVO reviewVO) {
        int result = reviewMapper.reviewUpdate(reviewVO);
        return result;
    }

    @Override
    public int reviewChkSelect(int M_NO, String isbn) {
        return reviewMapper.reviewChkSelect(M_NO, isbn);
    }


    @Override
    public ReviewsVO reviewList(ReviewPagingVO reviewPagingVO,String isbn) {
        ReviewsVO reviewsVO = new ReviewsVO();

        reviewsVO.setList(reviewMapper.getReviewPaging(reviewPagingVO,isbn));
        reviewsVO.setReviewPageVO(new ReviewPageVO(reviewPagingVO,reviewMapper.getReviewTotal(isbn)));

        return reviewsVO;
    }


    /*
    @Override
    public List<ReviewVO> getReviewPaging(ReviewPagingVO reviewPagingVO, String bookKey) {
        return reviewMapper.getReviewPaging(reviewPagingVO, bookKey);
    }

    @Override
    public ReviewPageVO getReviewPage(ReviewPagingVO reviewPagingVO, int total) {
        ReviewPageVO reviewPage = new ReviewPageVO();

        reviewPage.setReviewPagingVO(reviewPagingVO);
        reviewPage.setTotal(reviewMapper.getReviewTotal(reviewPagingVO.getR_BOOKKEY()));

        return reviewPage;

        //return reviewMapper.getReviewTotal(new ReviewPagingVO(reviewPagingVO,re));
    }

     */

}
