package com.homepage.careerdoctor.user.service;

import com.homepage.careerdoctor.user.domain.User;
import com.homepage.careerdoctor.user.dto.UserLoginDto;
import com.homepage.careerdoctor.user.dto.UserSignupDto;
import com.homepage.careerdoctor.user.repository.UserRepository;
import com.homepage.careerdoctor.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<CustomApiResponse<?>> signup(UserSignupDto dto) {

        Optional<User> findUser = userRepository.findByUserId(dto.getUserId());

        // 아이디 중복인 경우
        if (findUser.isPresent()) {
            return ResponseEntity.status(400)
                    .body(CustomApiResponse.createFailWithoutData(400, "중복된 아이디가 존재합니다."));
        }


        // 비밀번호와 비밀번호 확인이 일치하지 않는 경우
        if (!(dto.getPassword().equals(dto.getCheckPw()))) {
            return ResponseEntity.status(400)
                    .body(CustomApiResponse.createFailWithoutData(400, "비밀번호가 일치하지 않습니다."));
        }


        User newuser = User.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .build();

        userRepository.save(newuser);

        return ResponseEntity.status(201)
                .body(CustomApiResponse.createSuccess(201, null, "회원가입에 성공하였습니다."));
    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> login(UserLoginDto dto) {
        return null;
    }
}
