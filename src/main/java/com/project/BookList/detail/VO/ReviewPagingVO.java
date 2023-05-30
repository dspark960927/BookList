package com.project.BookList.detail.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class ReviewPagingVO {
    private int pageNum; //현재 페이지
    private int amount; //한 페이지 당 보여질 갯수
    private int skip; //스킵할 게시물수((pageNum-1)*amount)

    private String isbn;

    public ReviewPagingVO(){
        this(1,10);
        this.skip = 0;
    }

    public ReviewPagingVO(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum-1) * amount;
    }

    public int getPageNum(){
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.skip = (pageNum-1) * this.amount;
        this.pageNum = pageNum;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.skip = (this.pageNum-1) * amount;
        this.amount = amount;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String makeQueryString(int pageNum) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("isbn", isbn)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

}
