package com.project.BookList.mypage.mapper;

import com.project.BookList.mypage.VO.MyLikelistResultVO;
import com.project.BookList.mypage.VO.MyReviewResultVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {
    List<MyLikelistResultVO> myLikelistSelect(int M_NO);

    List<MyReviewResultVO> myReviewSelect(int M_NO);
}
