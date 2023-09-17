package com.vn.devmaster.quanlysinhvien.demosinhvien.mapper;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Subject;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.SubjectDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectMapper implements EntityMapper<Subject,  SubjectDTO>{
    @Override
    public Subject toEntity(SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public List<Subject> toEntity(List<SubjectDTO> d) {
        return null;
    }

    @Override
    public SubjectDTO toDto(Subject subject) {
        SubjectDTO dto= SubjectDTO.builder().name(subject.getName()).build();
        return dto;
    }

    @Override
    public List<SubjectDTO> toDto(List<Subject> e) {
        List<SubjectDTO> dtos=new ArrayList<>();
        e.forEach(subject -> {
            dtos.add(toDto(subject));
        });
        return dtos;
    }
}
