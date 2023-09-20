package com.vn.devmaster.quanlysinhvien.demosinhvien.domain;

import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// lấy ra sinh viên học lớp DEV02
@SqlResultSetMapping(
        name = "/Student_DEV02",
        classes = {
                @ConstructorResult(
                        targetClass = StudentDTO1.class,
                        columns = {
//                            @ColumnResult(name = "first_name",type = String.class),
//                            @ColumnResult(name = "last_name",type = String.class),
                                @ColumnResult(name = "fullName",type = String.class),
                                @ColumnResult(name = "nameClasses",type = String.class)
                                ,@ColumnResult(name = "nameSubject",type = String.class)
                            ,@ColumnResult(name = "point",type = int.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Student.getClasses_DEV02",
        query = " select concat(first_name,' ',last_name) as fullName,c.nameClasses,s3.nameSubject,ss.point from student s inner join\n " +
                "    student_subject ss on s.id = ss.id_student\n " +
                "    inner join subject s3 on ss.id_subject = s3.id\n " +
                "    inner join classes c on s.classes_id = c.id\n " +
                " where c.nameClasses = 'DEV02' ",
        resultSetMapping = "/Student_DEV02",
        resultClass = Student.class
)
// ly sinh viên có điểm >= 8 (2)
@SqlResultSetMapping(
        name = "/Student_Pont_8",
        classes = {
                @ConstructorResult(
                        targetClass = StudentDTO_Point_8.class,
                        columns = {
                                @ColumnResult(name = "id",type = Integer.class),
                                @ColumnResult(name = "first_name",type = String.class),
                                @ColumnResult(name = "last_name",type = String.class),
                                @ColumnResult(name = "nameSubject",type = String.class),
                                @ColumnResult(name = "point",type = int.class),
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Student.getPoint_8",
        query = " select distinct s.id,s.first_name,s.last_name,s2.nameSubject,ss.point from student s\n" +
                "    inner join student_subject ss on s.id = ss.id_student\n" +
                "    inner join `manage-student`.subject s2 on ss.id_subject = s2.id\n" +
                "where ss.point >= 8",
        resultClass = Student.class,
        resultSetMapping = "/Student_Pont_8"
)
//
@SqlResultSetMapping(
        name = "/Address_Student",
        classes = {
                @ConstructorResult(
                        targetClass = AdressDTO1.class,
                        columns = {
                                @ColumnResult(name = "id",type = Integer.class),
                                @ColumnResult(name = "first_name",type = String.class),
                                @ColumnResult(name = "last_name",type = String.class),
                                @ColumnResult(name = "name",type = String.class),
                                @ColumnResult(name = "city",type = String.class),
                                @ColumnResult(name = "district",type = String.class),
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Student.getAddress_student",
        query = "select s.id,s.first_name,s.last_name,a.name,a.city,a.district\n" +
                "from adress a inner join `manage-student`.student s on a.id = s.id_address",
        resultClass = Student.class,
        resultSetMapping = "/Address_Student"
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
