package com.project.BookList.detail.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikelistVO {
    private int L_NO;
    private int M_NO;
    private int L_LIKECHK;
    private String L_BOOKKEY;
}
