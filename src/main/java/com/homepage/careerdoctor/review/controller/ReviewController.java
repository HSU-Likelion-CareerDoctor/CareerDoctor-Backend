package com.homepage.careerdoctor.review.controller;

import com.homepage.careerdoctor.review.dto.ReviewWriteRequestDto;
import com.homepage.careerdoctor.review.service.ReviewServiceImpl;
import com.homepage.careerdoctor.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/careerdoctor")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @PostMapping("/write-review/{reportId}")
    private ResponseEntity<CustomApiResponse<?>> writeReview (@PathVariable("reportId") Long reportId, @Valid @RequestBody ReviewWriteRequestDto dto) {
        return reviewService.writeReview(reportId, dto);
    }

    @GetMapping("/reviews")
    private ResponseEntity<CustomApiResponse<?>> getReviews() {
        return reviewService.getReviews();
    }
}
