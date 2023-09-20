package com.vn.devmaster.quanlysinhvien.demosinhvien.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO_Point_8 {
    private Integer id;
    private String first_name;
    private String last_name;
    private String nameSubject;
    private int point;

}
