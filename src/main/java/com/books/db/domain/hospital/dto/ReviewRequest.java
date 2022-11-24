package com.books.db.domain.hospital.dto;

import com.books.db.domain.hospital.entity.Hospital;
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