package com.project.BookList.detail.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {
    private int R_NO;
    private int M_NO;
    private String R_CONTS;
    private String R_DATE;
    private String R_BOOKKEY;
}
