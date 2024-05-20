package com.homepage.careerdoctor.user.controller;

import com.homepage.careerdoctor.user.dto.UserSignupDto;
import com.homepage.careerdoctor.user.service.UserServiceImpl;
import com.homepage.careerdoctor.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<CustomApiResponse<?>> signup(@Valid @RequestBody UserSignupDto dto) {
        return userService.signup(dto);
    }
}
