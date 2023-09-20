package com.vn.devmaster.quanlysinhvien.demosinhvien.responsitory;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Adress;
import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Student;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.AdressDTO1;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO1;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO_Point_8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentReponsitory extends JpaRepository<Student, Integer> {
    // viết query theo native
//    @Query(nativeQuery = true,value = "select * from student" + "where first_name = :name")
//    List<Student> filterByName(@Param("name") String name);

    //HQL - tìm dữ liệu theo tên sinh viên
    @Query(value = "select s from Student s where s.first_name like concat('%',:name,'%') ")
    List<Student> filterByName(@Param("name") String name);

//    List<Student> finAllByFirstName(String name);

    // lấy toàn bộ dữ liệu address
    @Query(value = "select a from Adress a")
    List<Adress> getAllAddress();

    @Query(value = "select a from Adress a where a.id = :id ")
    Adress getOneAddress(@Param("id") Integer id);

    @Query(value = " select s.* from student s inner join adress a on s.id_address = a.id\n " +
            " where a.city = 'Hà Nội' ",nativeQuery = true)
    List<Student>   getAddressHN();

    // lâý ra sinh viên ở lơp DEV01
    @Query(value = " select s.* from student s inner join classes c on c.id = s.classes_id\n " +
            " where c.name like '%DEV01%' ",nativeQuery = true)
    List<Student> getClasses_DEV01();

    // lấy ra sinh viên học môn toán
    @Query(value = " select s.* from student s inner join `manage-student`.subject s2 on s.subject_id = s2.id\n " +
            " where s2.name = 'toán' ",nativeQuery = true)
    List<Student> getSubject();
    @Query(value = " select distinct s.* from student s inner join `manage-student`.student_subject ss on s.id = ss.id_student\n " +
            " where ss.point >= 8 ",nativeQuery = true)
    List<Student> getPoint();

    // lấy ra sinh viên lớp DEV02 gồm (first_name+last_name),tên lớp,tên môn,điểm
    @Query(nativeQuery = true)
    List<StudentDTO1> getClasses_DEV02();

    // lấy ra sinh viên có điểm >=8
    @Query(nativeQuery = true)
    List<StudentDTO_Point_8> getPoint_8();

    // lấy ra address của sinh viên
    @Query(nativeQuery = true)
    List<AdressDTO1> getAddress_student();
//    @Query(nativeQuery = true)
//    List<AdressDTO1> getAddress_student1();
}

