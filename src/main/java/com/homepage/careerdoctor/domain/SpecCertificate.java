package com.homepage.careerdoctor.domain;

import com.homepage.careerdoctor.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC) // 이 생성자를 모두에게 공개
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "SPEC_CERTIFICATES")
public class SpecCertificate extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private Long specId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @Embedded
    private Degree degree;

    @OneToMany(mappedBy = "specCertificate")
    private List<Language> languages;

    @OneToMany(mappedBy = "specCertificate")

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "SPEC_CERTIFICATE")
public class SpecCertificate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPEC_ID")
    private Long specId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH")
    private String birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(name = "IS_PUBLIC")
    private boolean isPublic;

    @OneToOne(mappedBy = "specCertificate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Degree degree;

    @OneToMany(mappedBy = "specCertificate")
>>>>>>> c409ef801c076c8eec75cec332331871119f061d
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "specCertificate")
    private List<Activity> activities;

    @OneToMany(mappedBy = "specCertificate")
<<<<<<< HEAD
=======
    private List<Language> languages;

    @OneToMany(mappedBy = "specCertificate")
>>>>>>> c409ef801c076c8eec75cec332331871119f061d
    private List<Career> careers;

    @OneToMany(mappedBy = "specCertificate")
    private List<Etc> etcs;

<<<<<<< HEAD
    @Column(name = "name")
    private String name;

    @Column(name = "birth") // ex) 20241209
    private String birth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    @Column(name = "is_public")
    private boolean isPublic;


    // getter and setter
    public void createSpecCertificate(User user, Degree degree, List<Language> languages, List<Certificate> certificates,
                                                 List<Activity> activities, List<Career> careers, List<Etc> etcs, String name,
                                                 String birth, Gender gender, Level level, boolean isPublic) {
        // SpecCertificate 객체를 생성하고 필드를 설정
        this.user = user;
        this.degree = degree;
        this.languages = languages;
        this.certificates = certificates;
        this.activities = activities;
        this.careers = careers;
        this.etcs = etcs;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.level = level;
        this.isPublic = isPublic;

        // SpecCertificate 객체를 반환 // service에서 레포지토리 사용하여 저장
    }
=======
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private User user;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d

}
