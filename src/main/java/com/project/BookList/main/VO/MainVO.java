package com.project.BookList.main.VO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainVO {
    private String title; //상품명
    private String author; //저자
    private String cover; //표지
    private String isbn; //13자리 ISBN
}
