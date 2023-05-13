package com.project.BookList.member.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private int M_NO;
    private String M_ID;
    private String M_PW;
    private String M_NAME;
    private String M_NICKNAME;
    private String M_BDATE;
}
