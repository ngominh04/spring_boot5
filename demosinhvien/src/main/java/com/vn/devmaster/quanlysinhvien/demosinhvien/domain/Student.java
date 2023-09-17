package com.vn.devmaster.quanlysinhvien.demosinhvien.domain;

import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.ClassesDto;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO1;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SqlResultSetMapping(
        name = "/Student_DEV02",
        classes = {
                @ConstructorResult(
                        targetClass = StudentDTO1.class,
                        columns = {
                                @ColumnResult(name = "first_name",type = Student.class),
                                @ColumnResult(name = "last_name",type = StudentDTO.class),
                                @ColumnResult(name = "name",type = ClassesDto.class),
                                @ColumnResult(name = "name",type = SubjectDTO.class)
//                                ,@ColumnResult(name = "point",type = StudentSubject.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Student.getClasses_DEV02",
        query = " select concat(s.first_name,' ',s.last_name)as ten,c.name,s3.name,ss.point from student s inner join\n " +
                "     student_subject ss on s.id = ss.id_student\n " +
                "     inner join subject s3 on ss.id_subject = s3.id\n " +
                "     inner join classes c on s.classes_id = c.id\n " +
                " where c.name = 'DEV02' ",
        resultSetMapping = "/Student_DEV02",
        resultClass = Student.class
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @OneToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "id_address")
    Adress address;

//    @ManyToMany
    @ManyToMany
        @JoinTable(
                name = "student_subject",
                joinColumns = @JoinColumn(name = "id_student"),
                inverseJoinColumns = @JoinColumn(name = "id_subject")
        )
    List<Subject> subjects=new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "classes_id")
    @Fetch(FetchMode.JOIN)
    private Classes classes;
}