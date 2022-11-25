package com.spbt.jpa.service;

import com.spbt.jpa.domain.hospital.dto.ReviewRequest;
import com.spbt.jpa.domain.hospital.dto.ReviewResponse;
import com.spbt.jpa.domain.hospital.entity.Hospital;
import com.spbt.jpa.domain.hospital.entity.Review;
import com.spbt.jpa.repository.HospitalRepository;
import com.spbt.jpa.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiece {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        Hospital hospital = hospitalRepository.findById(reviewRequest.getHospitalId()).orElseThrow(() -> new RuntimeException("해당 병원을 찾을 수 없습니다."));
        Review review = Review.builder()
                .title(reviewRequest.getReviewTitle())
                .userName(reviewRequest.getReviewAuthor())
                .content(reviewRequest.getReviewContent())
                .hospital(hospital)
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(savedReview.getTitle(), savedReview.getUserName(),
                savedReview.getContent(), "리뷰 등록에 성공했습니다.");
    }

    public ReviewResponse findByReviewId(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 리뷰를 찾을 수 없습니다."));
        ReviewResponse reviewResponse = new ReviewResponse(review.getTitle(), review.getUserName(),
                review.getContent(), String.format("id: %d 의 Review를 찾았습니다.", id));
        return reviewResponse;
    }

    public List<ReviewResponse> getReviewByHospitalId(Integer hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("해당 병원을 찾을 수 없습니다."));
        List<Review> reviews = reviewRepository.findByHospital(hospital);
        List<ReviewResponse> reviewResponses = reviews.stream().map(ReviewResponse::new).collect(Collectors.toList());
        return reviewResponses;
    }
}
