package com.books.db.service;

import com.books.db.domain.hospital.dto.ReviewRequest;
import com.books.db.domain.hospital.dto.ReviewResponse;
import com.books.db.domain.hospital.entity.Hospital;
import com.books.db.domain.hospital.entity.Review;
import com.books.db.repository.HospitalRepository;
import com.books.db.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ReviewResponse findByReviewId(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (!optionalReview.isEmpty()) {
            Review review = optionalReview.get();
            ReviewResponse reviewResponse = new ReviewResponse(review.getTitle(), review.getUserName(),
                    review.getContent(), String.format("id: %d 의 Review를 찾았습니다.", id));
            return reviewResponse;
        } else {
            ReviewResponse reviewResponse = new ReviewResponse(null, null,
                    null, String.format("id: %d 의 Review를 찾지못했습니다. \n 다시 시도해주세요.", id));
            return reviewResponse;
        }
    }
}
