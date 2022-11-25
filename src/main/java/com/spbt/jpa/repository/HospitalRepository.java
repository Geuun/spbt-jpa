package com.spbt.jpa.repository;

import com.spbt.jpa.domain.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    // Get Hospital total Count
    Long countBy();
}
