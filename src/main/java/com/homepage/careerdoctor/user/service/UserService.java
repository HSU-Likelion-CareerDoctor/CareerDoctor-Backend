package com.homepage.careerdoctor.user.service;

import com.homepage.careerdoctor.user.dto.UserLoginDto;
import com.homepage.careerdoctor.user.dto.UserSignupDto;
import com.homepage.careerdoctor.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<CustomApiResponse<?>> signup(UserSignupDto dto);
    public ResponseEntity<CustomApiResponse<?>> login(UserLoginDto dto);
}
