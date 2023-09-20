package com.vn.devmaster.quanlysinhvien.demosinhvien.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "classes")


public class Classes {
    @Id
    @JoinColumn(name = "id")
    private Integer id;
    @JoinColumn(name = "nameClasses")
    private String name;

    @OneToMany(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id")
    @Fetch(FetchMode.JOIN)
    private List<Student> students;
}
