package com.homepage.careerdoctor.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSigninDto {
    @NotEmpty(message = "아이디를 작성해 주세요.")
    private String userId;

    @NotEmpty(message = "비밀번호를 작성해 주세요.")
    private String password;
}
