package com.books.db.controller;

import com.books.db.domain.hospital.dto.HospitalResponse;
import com.books.db.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospital(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospitalResponse(id);
        log.info(hospitalResponse.toString());
        return ResponseEntity
                .ok()
                .body(hospitalResponse);
    }
}
