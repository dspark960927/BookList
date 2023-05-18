package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.LikelistVO;
import com.project.BookList.detail.mapper.LikelistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikelistServiceImpl implements LikelistService{

    @Autowired
    LikelistMapper likelistMapper;

    @Override
    public int likelistInsert(LikelistVO likelistVO) {
        return likelistMapper.likelistInsert(likelistVO);
    }

    @Override
    public LikelistVO likkelistSelect(int M_NO, String L_BOOKKEY) {
        return likelistMapper.likelistSelect(M_NO,L_BOOKKEY);
    }

    @Override
    public int likelistDelete(int L_ID) {
        return likelistMapper.likelistDelete(L_ID);
    }
}
