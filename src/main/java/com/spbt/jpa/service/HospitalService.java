package com.spbt.jpa.service;

import com.spbt.jpa.domain.hospital.dto.HospitalResponse;
import com.spbt.jpa.domain.hospital.dto.HospitalTotalCountResponse;
import com.spbt.jpa.domain.hospital.entity.Hospital;
import com.spbt.jpa.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalResponse getHospitalResponse(Integer id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 병원을 찾을 수 없습니다."));
        HospitalResponse hospitalResponse = HospitalResponse.of(hospital);
        return hospitalResponse;
    }


    public HospitalTotalCountResponse getHospitalTotalCount() {
        Long hospitalTotalcount = hospitalRepository.countBy();
        HospitalTotalCountResponse hospitalTotalCountResponse = new HospitalTotalCountResponse(hospitalTotalcount);
        return hospitalTotalCountResponse;
    }
}
