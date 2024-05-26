package com.homepage.careerdoctor.domain;

import com.homepage.careerdoctor.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
<<<<<<< HEAD
@Table(name = "REVIEWS")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private SpecReport specReport;

    @Column(name = "opinion")
    private int opinion;

    @Column(name = "best_point")
    private int bestPoint;

    @Column(name = "review_content")
=======
@Table(name = "REVIEW")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPORT_ID")
    private SpecReport specReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    private OPINION opinion;

    @Enumerated(EnumType.STRING)
    private BestPoint bestPoint;

    @Column(name = "REVIEW_CONTENT")
>>>>>>> c409ef801c076c8eec75cec332331871119f061d
    private String reviewContent;
}
