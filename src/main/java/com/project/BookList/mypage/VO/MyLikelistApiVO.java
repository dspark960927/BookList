package com.project.BookList.mypage.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyLikelistApiVO {
    private int L_NO;
    private String title; //상품명
    private String cover; //표지
    private String isbn;
}
