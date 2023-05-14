package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
