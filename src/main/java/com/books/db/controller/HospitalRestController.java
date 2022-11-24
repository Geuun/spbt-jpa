package com.books.db.controller;

import com.books.db.domain.hospital.dto.HospitalResponse;
import com.books.db.domain.hospital.dto.ReviewRequest;
import com.books.db.domain.hospital.dto.ReviewResponse;
import com.books.db.service.HospitalService;
import com.books.db.service.ReviewServiece;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospital(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospitalResponse(id);
        log.info(hospitalResponse.toString());
        return ResponseEntity
                .ok()
                .body(hospitalResponse);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity
                .ok()
                .body(reviewServiece.addReview(reviewRequest));
    }
}
