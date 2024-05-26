package com.homepage.careerdoctor.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSigninDto {
    @NotEmpty(message = "아이디를 작성해 주세요.")
    private String userId;

    @NotEmpty(message = "비밀번호를 작성해 주세요.")
    private String password;
}
