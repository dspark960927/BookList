package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewVO;
import com.project.BookList.detail.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public int reviewInsert(ReviewVO reviewVO) {
        return reviewMapper.ReviewInsert(reviewVO);
    }
}
