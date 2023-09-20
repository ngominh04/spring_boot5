package com.vn.devmaster.quanlysinhvien.demosinhvien.domain;

import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.AdressDTO1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "adress")
public class Adress {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    // 1 address tới nhiều student
//    @OneToMany
//            @JoinColumn(name = "id_address")
//    List<Student> students=new ArrayList<>(); // list cho lặp lại dữ liệu , set ko cho lặp dữ liệu

}
