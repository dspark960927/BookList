package com.project.BookList.detail.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPageVO {
    private int pageStart;
    private int pageEnd;
    private boolean next;
    private boolean prev;
    private int total;
    private ReviewPagingVO reviewPagingVO;

    public ReviewPageVO(ReviewPagingVO reviewPagingVO, int total){
        this.reviewPagingVO = reviewPagingVO;

        this.total = total;

        this.pageEnd = (int)(Math.ceil(reviewPagingVO.getPageNum()/10.0))*10;

        this.pageStart = this.pageEnd - 9;

        int realEnd = (int)(Math.ceil(total*1.0/reviewPagingVO.getAmount()));

        if(realEnd < pageEnd){
            this.pageEnd = realEnd;
        }

        this.prev = this.pageStart > 1;

        this.next = this.pageEnd < realEnd;
    }
}
