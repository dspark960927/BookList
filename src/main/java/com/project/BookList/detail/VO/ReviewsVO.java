package com.project.BookList.detail.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsVO {
    List<ReviewVO> list;
    ReviewPageVO reviewPageVO;
}
