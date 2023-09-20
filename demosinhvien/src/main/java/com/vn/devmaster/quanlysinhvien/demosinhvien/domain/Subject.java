package com.vn.devmaster.quanlysinhvien.demosinhvien.domain;

import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.AdressDTO1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@SqlResultSetMapping(
//        name = "/Address_Student1",
//        classes = {
//                @ConstructorResult(
//                        targetClass = AdressDTO1.class,
//                        columns = {
//                                @ColumnResult(name = "id",type = Integer.class),
//                                @ColumnResult(name = "first_name",type = String.class),
//                                @ColumnResult(name = "last_name",type = String.class),
//                                @ColumnResult(name = "name",type = String.class),
//                                @ColumnResult(name = "city",type = String.class),
//                                @ColumnResult(name = "district",type = String.class),
//                        }
//                )
//        }
//)
//@NamedNativeQuery(
//        name = "Subject.getAddress_student1",
//        query = "select s.id,s.first_name,s.last_name,a.name,a.city,a.district\n" +
//                "from adress a inner join `manage-student`.student s on a.id = s.id_address",
//        resultClass = Subject.class,
//        resultSetMapping = "/Address_Student1"
//)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nameSubject",length = 250)
    private String name;

    @ManyToMany(mappedBy = "subjects")
    List<Student> students=new ArrayList<>();
}
