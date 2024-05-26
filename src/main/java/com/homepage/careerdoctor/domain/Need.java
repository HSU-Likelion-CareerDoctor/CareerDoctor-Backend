package com.homepage.careerdoctor.domain;

import com.homepage.careerdoctor.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
<<<<<<< HEAD
@Table(name = "NEEDSPECS")
public class Need extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "need")
    private Long needId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private SpecReport specReport;

    @ElementCollection(targetClass = NeedSpec.class)
    @CollectionTable(name = "need_specs", joinColumns = @JoinColumn(name = "need_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "need_spec")
    private List<NeedSpec> needSpecs;
=======
@Table(name = "NEED")
public class Need extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEED_ID")
    private Long needId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPORT_ID")
    private SpecReport specReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    private NeedName needName;
>>>>>>> c409ef801c076c8eec75cec332331871119f061d
}
