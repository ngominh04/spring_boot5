package com.vn.devmaster.quanlysinhvien.demosinhvien.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdressDTO1 {
    private Integer id;
    private String first_name;
    private String last_name;
    private String name;
    private String city;
    private String district;
}
