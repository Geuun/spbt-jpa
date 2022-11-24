package com.books.db.service;

import com.books.db.domain.hospital.dto.ReviewRequest;
import com.books.db.domain.hospital.dto.ReviewResponse;
import com.books.db.domain.hospital.entity.Hospital;
import com.books.db.domain.hospital.entity.Review;
import com.books.db.repository.HospitalRepository;
import com.books.db.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiece {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewServiece(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(reviewRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewRequest.getReviewTitle())
                .userName(reviewRequest.getReviewAuthor())
                .content(reviewRequest.getReviewContent())
                .hospital(optionalHospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(savedReview.getTitle(), savedReview.getUserName(),
                savedReview.getContent(), "리뷰 등록이 성공했습니다.");
    }
}
