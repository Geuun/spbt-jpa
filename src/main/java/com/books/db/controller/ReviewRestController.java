package com.books.db.controller;

import com.books.db.domain.hospital.dto.ReviewRequest;
import com.books.db.domain.hospital.dto.ReviewResponse;
import com.books.db.service.HospitalService;
import com.books.db.service.ReviewServiece;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewRestController {

    private final ReviewServiece reviewServiece;
    private final HospitalService hospitalService;

    public ReviewRestController(ReviewServiece reviewServiece, HospitalService hospitalService) {
        this.reviewServiece = reviewServiece;
        this.hospitalService = hospitalService;
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
