package com.vn.devmaster.quanlysinhvien.demosinhvien.service;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Adress;
import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Student;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.AddressDTO;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO;
import com.vn.devmaster.quanlysinhvien.demosinhvien.mapper.StudentMapper;
import com.vn.devmaster.quanlysinhvien.demosinhvien.responsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentReponsitory studentReponsitory;

    @Autowired
    private StudentMapper studentMapper;
    public List<Student> getAll(){
        List<Student> students=studentReponsitory.findAll();
        return students;
    }

    // lưu 1 sinh viên
    public void save(StudentDTO studentDTO){
        Student student = studentMapper.toEntity(studentDTO);
        studentReponsitory.save(student);
    }


    // lưu nhiều sinh viên
    public void save(List<StudentDTO> dtos) {
        List<Student> students=studentMapper.toEntity(dtos);
//        students.forEach(student -> {
//            studentReponsitory.save(student);
//        });
        studentReponsitory.saveAll(students);
    }

//    public List<Student> filterByName(String name) {
//        List<Student> students=studentReponsitory.filterByName(name);
//        return students;
//    }

    public List<StudentDTO> filterByName(String name) {
    List<Student> students=studentReponsitory.filterByName(name);
    return studentMapper.toDTO(students);
    }

    public List<AddressDTO> getAllAddress(){
        List<Adress> adresses=studentReponsitory.getAllAddress();
        return  studentMapper.toAddress(adresses);
    }
    public AddressDTO getOneAddress(Integer id){
        Adress address=studentReponsitory.getOneAddress(id);
        return studentMapper.toAddress(address);
    }

    public List<StudentDTO> getAddressHN( ){
        List<Student> students=studentReponsitory.getAddressHN();
        return studentMapper.toAddressHN(students);
    }
    public List<StudentDTO> getClasses_DEV01(){
        List<Student> students=studentReponsitory.getClasses_DEV01();
        return studentMapper.toClasses(students);
    }

    public List<StudentDTO> getSubject(){
        List<Student> students=studentReponsitory.getSubject();
        return studentMapper.toSubject(students);
    }

    public List<StudentDTO> getPoint(){
        List<Student> students=studentReponsitory.getPoint();
        return studentMapper.toPoint(students);
    }
}
