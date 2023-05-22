package com.project.BookList.mypage.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyReviewResultVO {
    private int R_NO;
    private String R_CONTS;
    private String R_DATE;
    private String R_BOOKKEY;
}
