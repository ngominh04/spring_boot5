package com.vn.devmaster.quanlysinhvien.demosinhvien.mapper;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Adress;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.AddressDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMapper implements EntityMapper<Adress, AddressDTO>{
    @Override
    public Adress toEntity(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public List<Adress> toEntity(List<AddressDTO> d) {
        return null;
    }

    @Override
    public AddressDTO toDto(Adress adress) {
        return AddressDTO.builder().id(adress.getId()).city(adress.getCity()).name(adress.getName()).district(adress.getDistrict()).build();
    }

    @Override
    public List<AddressDTO> toDto(List<Adress> e) {
        return null;
    }
}
