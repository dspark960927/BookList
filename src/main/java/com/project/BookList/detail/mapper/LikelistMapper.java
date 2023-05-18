package com.project.BookList.detail.mapper;

import com.project.BookList.detail.VO.LikelistVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikelistMapper {
    int likelistInsert(LikelistVO likelistVO);

    LikelistVO likelistSelect(int M_NO, String L_BOOKKEY);

    int likelistDelete(int L_NO);
}
