package com.homepage.careerdoctor.specCertificate.dto;

import com.homepage.careerdoctor.domain.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

<<<<<<< HEAD
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateSpecDto {
    private String userId; // service로 넘김

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;
=======
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateSpecDto {
    private String userId;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d

    @NotEmpty(message = "생일을 입력해주세요.")
    private String birth;

    @NotEmpty(message = "성별을 입력해주세요.")
    private Gender gender;

    @NotEmpty(message = "학력을 입력해주세요.")
    private SchoolDiv schoolDiv;

    @NotEmpty(message = "입학년월을 입력해주세요.")
    private String entranceYear;

    @NotEmpty(message = "입학 구분을 입력해주세요.")
    private EntranceDiv entranceDiv;

    @NotEmpty(message = "졸업(예정)년월을 입력해주세요.")
    private GraduateDiv graduateDiv;

    @NotEmpty(message = "전공을 입력해주세요.")
    private String major;

    @NotEmpty(message = "학점을 입력해주세요.")
    private Double avgCredit;

    @NotEmpty(message = "보유 자격증을 입력해주세요.")
    private ArrayList<String> certificate;
    private String certificateName;

    @NotEmpty(message = "대외활동을 입력해주세요.")
    private ArrayList<String> activity;
    private String activityName;

    @NotEmpty(message = "언어를 입력해주세요.")
<<<<<<< HEAD
    private LanguageName languageName;

    @NotEmpty(message = "언어 레벨을 입력해주세요.")
    private LanguageLevel languageLevel;

    //private Language language;
=======
    private ArrayList<String> language;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d

    @NotEmpty(message = "경력을 입력해주세요.")
    private ArrayList<Career> careers;

    @NotEmpty(message = "기타를 입력해주세요.")
    private String etc;
}
