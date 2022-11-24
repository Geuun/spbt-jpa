package com.spbt.jpa.domain.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private Integer hospitalId;
    private String reviewTitle;
    private String reviewAuthor; //리뷰 작성자
    private String reviewContent; //리뷰 콘텐츠
}