package com.project.BookList.detail.service;

import com.project.BookList.detail.VO.DetailVO;

import java.util.List;

public interface DetailService {
    List<DetailVO> getDetailList(String isbn);
}
