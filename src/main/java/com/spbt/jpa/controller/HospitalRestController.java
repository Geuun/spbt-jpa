package com.spbt.jpa.controller;

import com.spbt.jpa.domain.hospital.dto.HospitalResponse;
import com.spbt.jpa.domain.hospital.dto.HospitalTotalCountResponse;
import com.spbt.jpa.domain.hospital.dto.ReviewResponse;
import com.spbt.jpa.service.HospitalService;
import com.spbt.jpa.service.ReviewServiece;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewServiece reviewServiece;

    public HospitalRestController(HospitalService hospitalService, ReviewServiece reviewServiece) {
        this.hospitalService = hospitalService;
        this.reviewServiece = reviewServiece;
    }

    @GetMapping("/totalcounts")
    public ResponseEntity<HospitalTotalCountResponse> getHospitalTotalCount() {
        return ResponseEntity
                .ok()
                .body(hospitalService.getHospitalTotalCount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospital(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospitalResponse(id);
        log.info(hospitalResponse.toString());
        return ResponseEntity
                .ok()
                .body(hospitalResponse);
    }

    @GetMapping("/{id}/reviews") // id값의 병원 리뷰만 확인
    public ResponseEntity<List<ReviewResponse>> getReviewByHospitalId(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .body(reviewServiece.getReviewByHospitalId(id));
    }
}
