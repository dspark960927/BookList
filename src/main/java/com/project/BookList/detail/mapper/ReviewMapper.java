package com.project.BookList.detail.mapper;

import com.project.BookList.detail.VO.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {
    int ReviewInsert(ReviewVO reviewVO);

    List<ReviewVO> reviewSelect(String bookKey);

    int reviewDelete(int R_ID);

    int reviewUpdate(ReviewVO reviewVO);

}
