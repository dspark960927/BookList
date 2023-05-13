package com.project.BookList.member.mapper;

import com.project.BookList.member.VO.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int memberInsert(MemberVO member);

    public MemberVO memberLogin(MemberVO memberVO);
}