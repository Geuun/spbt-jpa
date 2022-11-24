package com.books.db.domain.hospital.dto;

import com.books.db.domain.hospital.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Integer hospitalId;
    private String hospitalName;
    private String hospitalRoadNameAddress;
    private List<ReviewResponse> reviewList;

    public static HospitalResponse of(Hospital hospital) {
        return HospitalResponse.builder()
                .hospitalId(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .hospitalRoadNameAddress(hospital.getRoadNameAddress())
                .reviewList(hospital.getReviews()
                        .stream()
                        .map(ReviewResponse::new)
                        .collect(Collectors.toList()))
                .build();
    }
}
