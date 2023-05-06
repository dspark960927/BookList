package com.project.BookList.member.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String M_ID;
    private String M_PW;
    private String M_NAME;
    private String M_NICKNAME;
    private String M_GENDER;
    private String M_BDATE;
}
