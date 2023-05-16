package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.ReviewVO;
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

}
