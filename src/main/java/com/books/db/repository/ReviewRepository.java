package com.books.db.repository;

import com.books.db.domain.hospital.entity.Hospital;
import com.books.db.domain.hospital.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHospital(Hospital hospital);
}
