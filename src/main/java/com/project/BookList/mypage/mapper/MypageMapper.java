package com.project.BookList.mypage.mapper;

import com.project.BookList.mypage.VO.MypageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {
    List<MypageVO> myLikelistSelect(int M_NO);
}
