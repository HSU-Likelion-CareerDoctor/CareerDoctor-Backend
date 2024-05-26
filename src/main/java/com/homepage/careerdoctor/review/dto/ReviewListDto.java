package com.homepage.careerdoctor.review.dto;

import com.homepage.careerdoctor.domain.BestPoint;
import com.homepage.careerdoctor.domain.Gender;
import com.homepage.careerdoctor.domain.Level;
import com.homepage.careerdoctor.domain.OPINION;
import com.homepage.careerdoctor.specReport.dto.ReportWantUserListDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

public class ReviewListDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewResponse {

        private Long reviewId;
        private String userId;
        private String reviewContent;
        private OPINION opinion;
        private BestPoint bestPoint;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    public static class SearchReviews {
        private List<ReviewListDto.ReviewResponse> reviews;

        public SearchReviews(List<ReviewListDto.ReviewResponse> reviews) {
            this.reviews = reviews;
        }
    }


}
