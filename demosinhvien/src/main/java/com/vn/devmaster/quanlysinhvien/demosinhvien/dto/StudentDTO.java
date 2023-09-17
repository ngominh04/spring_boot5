package com.vn.devmaster.quanlysinhvien.demosinhvien.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Integer id;
    private String frist_name;
    private String last_name;
    private AddressDTO addressDTO;

    private List<SubjectDTO> subjectDTOS;
    private ClassesDto classesDto;
}
