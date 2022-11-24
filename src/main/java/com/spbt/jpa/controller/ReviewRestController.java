package com.spbt.jpa.controller;

import com.spbt.jpa.domain.hospital.dto.ReviewRequest;
import com.spbt.jpa.domain.hospital.dto.ReviewResponse;
import com.spbt.jpa.service.ReviewServiece;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewRestController {

    private final ReviewServiece reviewServiece;

    public ReviewRestController(ReviewServiece reviewServiece) {
        this.reviewServiece = reviewServiece;
    }

    @GetMapping("/{id}") // 댓글 id값으로 리뷰 확인
    public ResponseEntity<ReviewResponse> findByReviewId(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(reviewServiece.findByReviewId(id));
    }

    @PostMapping("/{id}/reviews") //리뷰 등록
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity
                .ok()
                .body(reviewServiece.addReview(reviewRequest));
    }
}
