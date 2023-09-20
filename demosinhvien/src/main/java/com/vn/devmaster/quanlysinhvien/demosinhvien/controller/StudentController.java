package com.vn.devmaster.quanlysinhvien.demosinhvien.controller;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Student;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.*;
import com.vn.devmaster.quanlysinhvien.demosinhvien.responsitory.StudentReponsitory;
import com.vn.devmaster.quanlysinhvien.demosinhvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentReponsitory studentReponsitory;
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping("/student")
    String save(@RequestBody StudentDTO student){
        studentService.save(student);
        return "ok";
    }

    @PostMapping("/students")
    String save(@RequestBody List<StudentDTO> dtos){
        studentService.save( dtos);
        return "okkkkkkkkkk";
    }

//    @GetMapping("/filter-name")
//    List<Student> filterByName(@RequestParam("name") String name){
//        List<Student> dtos=studentService.filterByName(name);
//        return dtos;
//    }
    @GetMapping("/filter-name")
    List<StudentDTO> filterByName(@RequestParam("name") String name){
        List<StudentDTO> dtos=studentService.filterByName(name);
        return dtos;
    }

    @GetMapping("/AllAddress")
    List<AddressDTO> getAllAddress(){
        List<AddressDTO> dtos=studentService.getAllAddress();
        return dtos;
    }

    @GetMapping("/getOneAddress")
    AddressDTO getOneAddress(@Param("id") Integer id){
        return studentService.getOneAddress(id);
    }

    @GetMapping("/AddressHN")
    List<StudentDTO> getAddressHN(){
        List<StudentDTO> studentDTOS=studentService.getAddressHN();
        return studentDTOS;
    }

    // lấy ra sinh viên học lớp DEV01
    @GetMapping("/Classes_DEV01")
    List<StudentDTO> getClasses_DEV01(){
        List<StudentDTO> studentDTOS=studentService.getClasses_DEV01();
        return studentDTOS;
    }

    //Lấy ra sinh viên học môn toán
    @GetMapping("/Subject_Toan")
    List<StudentDTO> getSubject(){
        List<StudentDTO> studentDTOS=studentService.getSubject();
        return studentDTOS;
    }

    // lấy ra những sinh viên có điểm >=8
    @GetMapping("/Point")
    List<StudentDTO> getPoint(){
        List<StudentDTO> studentDTOS=studentService.getPoint();
        return studentDTOS;
    }

    // lấy sinh viên lớp DEV02
    @GetMapping("/Student_DEV02")
    ResponseEntity<List<StudentDTO1>> getClasses_DEV02(){
        return ResponseEntity.ok(studentReponsitory.getClasses_DEV02());
    }
    // lấy ra sinh viên có điểm >=8 (2)
    @GetMapping("/Student_Pont_8")
    ResponseEntity<List<StudentDTO_Point_8>> getPoint_8(){
        return ResponseEntity.ok(studentReponsitory.getPoint_8());
    }

    @GetMapping("/Address_Student")
    ResponseEntity<List<AdressDTO1>> getAddress_student(){return ResponseEntity.ok(studentReponsitory.getAddress_student());}

//    @GetMapping("/Address_Student1")
//    ResponseEntity<List<AdressDTO1>> getAddress_student1(){return ResponseEntity.ok(studentReponsitory.getAddress_student1());}
}
