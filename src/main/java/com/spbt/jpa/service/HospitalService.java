package com.spbt.jpa.service;

import com.spbt.jpa.domain.hospital.dto.HospitalResponse;
import com.spbt.jpa.domain.hospital.dto.HospitalTotalCountResponse;
import com.spbt.jpa.domain.hospital.entity.Hospital;
import com.spbt.jpa.repository.HospitalRepository;
import org.springframework.stereotype.Service;

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


    public HospitalTotalCountResponse getHospitalTotalCount() {
        Long hospitalTotalcount = hospitalRepository.countBy();
        HospitalTotalCountResponse hospitalTotalCountResponse = new HospitalTotalCountResponse(hospitalTotalcount);
        return hospitalTotalCountResponse;
    }
}
