package com.vn.devmaster.quanlysinhvien.demosinhvien.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Integer id;
    private String name;
    private String city;
    private String district;
}
