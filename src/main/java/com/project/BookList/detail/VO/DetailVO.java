package com.project.BookList.detail.VO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetailVO {
    private String title; //상품명
    private String author; //저자
    private String cover; //표지
    private String isbn; //13자리 ISBN
    private String pubdate; //출간일
    private String description; //상품설명
    private int pricestandard; //판매가
    private String publisher; //출판사
}
