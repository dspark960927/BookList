package com.project.BookList.detail.mapper;

import com.project.BookList.detail.VO.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    int ReviewInsert(ReviewVO reviewVO);
}
