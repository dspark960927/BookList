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

    @NotBlank(message = "아이디를 입력해주세요.")
    private String M_ID;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    //@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String M_PW;

    @NotBlank(message = "이름을 입력해주세요.")
    private String M_NAME;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String M_NICKNAME;

    @NotBlank(message = "생년월일를 입력해주세요.")
    private String M_BDATE;
}
