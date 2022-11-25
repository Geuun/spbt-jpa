package com.spbt.jpa.domain.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalTotalCountResponse {
    private Long hospitalTotalCount;
}
