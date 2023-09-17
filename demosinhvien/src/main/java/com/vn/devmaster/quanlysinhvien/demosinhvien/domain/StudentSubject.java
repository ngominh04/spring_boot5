//package com.vn.devmaster.quanlysinhvien.demosinhvien.domain;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "student_subject")
//public class StudentSubject {
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_student", nullable = false)
//    private Student idStudent;
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_subject", nullable = false)
//    private Subject idSubject;
//
//    @Column(name = "point")
//    private Integer point;
//
//}