package com.project.BookList.member.service;

import com.project.BookList.member.VO.MemberVO;
import com.project.BookList.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Override
    public int memberInsert(MemberVO member){
        return memberMapper.memberInsert(member);
    }

}
