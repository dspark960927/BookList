package com.project.BookList.member.service;

import com.project.BookList.member.VO.MemberVO;

public interface MemberService {
    int memberInsert(MemberVO member);

    MemberVO memberLogin(MemberVO member);
}
