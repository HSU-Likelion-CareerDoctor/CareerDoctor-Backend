package com.homepage.careerdoctor.domain;

import com.homepage.careerdoctor.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
<<<<<<< HEAD
@Table(name = "SPEC_REPORTS")
public class SpecReport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @Column(name = "report_title")
    private String reportTitle;

    @Column(name = "report_content")
    private String reportContent;

    @OneToOne(mappedBy = "specReport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Review review;

    @OneToOne(mappedBy = "specReport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Need need;
=======
@Table(name = "SPEC_REPORT")
public class SpecReport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    private Long reportId;

    @Column(name = "REPORT_TITLE")
    private String reportTitle;

    @Column(name = "REPORT_CONTENT")
    private String reportContent;


    @OneToMany(mappedBy = "specReport")
    private List<Review> reviews;

    @OneToMany(mappedBy = "specReport")
    private List<Need> needs;

    // 추가: User와의 관계 정의
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private User user;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d
}
