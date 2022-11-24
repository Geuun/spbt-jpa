package com.books.db.service;

import com.books.db.domain.hospital.dto.HospitalResponse;
import com.books.db.domain.hospital.dto.ReviewResponse;
import com.books.db.domain.hospital.entity.Hospital;
import com.books.db.domain.hospital.entity.Review;
import com.books.db.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospitalResponse(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        HospitalResponse hospitalResponse = HospitalResponse.of(hospital);
        return hospitalResponse;
    }


}
