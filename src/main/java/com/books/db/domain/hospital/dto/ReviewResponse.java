package com.books.db.domain.hospital.dto;

import com.books.db.domain.hospital.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private String reviewTitle; //리뷰 타이틀
    private String reviewAuthor; //리뷰 작성자
    private String reviewContent; //리뷰 콘텐츠
    private String message; //상태 메세지

    // Entity -> Dto
    public ReviewResponse (Review review) {
        this.reviewTitle = review.getTitle();
        this.reviewAuthor = review.getUserName();
        this.reviewContent = review.getContent();
    }
}
