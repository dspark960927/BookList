package com.project.BookList.main.VO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MainVO {
    private String title; //상품명
    private String author; //저자
    private String cover; //표지
    /*
    private String pubdate; //출간일
    private String description; //상품설명
    private String isbn13; //13자리 ISBN
    private int pricestandard; //판매가

    private String publisher; //출판사

     */
}
