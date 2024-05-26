package com.homepage.careerdoctor.specCertificate.service;

import com.homepage.careerdoctor.domain.*;
import com.homepage.careerdoctor.specCertificate.dto.CertificateSpecDto;
import com.homepage.careerdoctor.specCertificate.repository.SpecRepository;
import com.homepage.careerdoctor.user.repository.UserRepository;
import com.homepage.careerdoctor.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecCertificateServiceImpl implements SpecCertificateService {
    private final SpecRepository specRepository;
    private final UserRepository userRepository;

    // 스펙 진단하기
    @Override
    public ResponseEntity<CustomApiResponse<?>> certificateSpec(CertificateSpecDto certificateSpecDto) {

        if (certificateSpecDto.getUserId() == null) {
            // 비회원
            // userId = ""인 SpecCertificate 객체 생성 후 값 넣기
            String name = certificateSpecDto.getName();
            String birth = certificateSpecDto.getBirth();
            Gender gender = certificateSpecDto.getGender();
            SchoolDiv schoolDiv = certificateSpecDto.getSchoolDiv();
            String entranceYear = certificateSpecDto.getEntranceYear();
            EntranceDiv entranceDiv = certificateSpecDto.getEntranceDiv();
            GraduateDiv graduateDiv = certificateSpecDto.getGraduateDiv();
            String major = certificateSpecDto.getMajor();
            Double avgCredit = certificateSpecDto.getAvgCredit();
            ArrayList<Certificate> certificates = certificateSpecDto.getCertificates();
            ArrayList<Activity> activities = certificateSpecDto.getActivities();
            ArrayList<Language> languages = certificateSpecDto.getLanguages();
            ArrayList<Career> careers = certificateSpecDto.getCareers();
            ArrayList<Etc> etcs = certificateSpecDto.getEtcs();

            // 보유 자격증, 대외활동, 경력사항도 똑같ㅇㅣ..


            // 스펙 인증서 객체에 언어 추가
            //specCertificate.getLanguages().add(language);

            // userId가 없는 SpecCertificate
            SpecCertificate createNoUserIdSpecCertificate = SpecCertificate.builder()
                    .user(null)
                    .name(name)
                    .birth(birth)
                    .schoolDiv(schoolDiv)
                    .gender(gender)
                    .languages(languages)
                    .build();
            specRepository.save(createNoUserIdSpecCertificate);

        } else {
            // 회원
            // userId 있는 SpecCertificate 객체 생성 후 값 넣기
            Optional<User> foundUser = userRepository.findByUserId(certificateSpecDto.getUserId()); // userID로 해당하는 회원이 있는지


            // userId가 있는 SpecCertificate
            /*foundUser.builder()
                    .user(foundUser)

                    .build();
            specRepository.save(createSpecCertificate);*/


        }

        /*// userId가 null인지 아닌지 검사
        if(userId == null) { // null일 때 비회원
            //userId가 ""(null, 프론트에서 requestBody의 userId로 넘겨준 값)값이라면, 비회원
            // 로그인 안 된 상태 -> 진단하기 후 유저 아이디가 없는 스펙 DB에 저장
            SpecCertificate specCertificate = new SpecCertificate(); // 객체 선언
            specCertificate.createSpecCertificate(userId, )

        } else { // 회원이라면
            // 로그인된 상태 -> 내 스펙에 저장 // userId를 DB에 존재하는지 확인
            // 1. 사용자가 스펙 진단하기에 요청한 아이디가 DB에 존재하는지 확인
            Optional<User> foundedUser = userRepository.findByUserId(userId);
        }*/


        // 존재
        // DB에 존재하는 회원인지
        // 연관관계 설정
        // 스펙
        return null;
    }
}