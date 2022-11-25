package com.spbt.jpa.repository;

import com.spbt.jpa.domain.hospital.entity.Hospital;
import com.spbt.jpa.domain.hospital.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 병원 리뷰 리스트
    List<Review> findByHospital(Hospital hospital);
}
