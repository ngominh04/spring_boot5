package com.vn.devmaster.quanlysinhvien.demosinhvien.mapper;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Classes;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.ClassesDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesMapper implements EntityMapper<Classes, ClassesDto>{
    @Override
    public Classes toEntity(ClassesDto classesDto) {
        return null;
    }

    @Override
    public List<Classes> toEntity(List<ClassesDto> d) {
        return null;
    }

    @Override
    public ClassesDto toDto(Classes classes) {
        ClassesDto dto=ClassesDto.builder().name(classes.getName()).build();
        return dto;
    }

    @Override
    public List<ClassesDto> toDto(List<Classes> e) {
//        List<ClassesDto> dtos=new ArrayList<>();
//        e.forEach(classes -> {
//            dtos.add(toDto(classes));
//        });
        return null;
    }

}
