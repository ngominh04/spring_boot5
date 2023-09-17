package com.vn.devmaster.quanlysinhvien.demosinhvien.mapper;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Adress;
import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Student;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.AddressDTO;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private ClassesMapper classesMapper;

    public StudentDTO toDto(Student student){
        StudentDTO studentDTO=StudentDTO.builder()
                .classesDto(classesMapper.toDto(student.getClasses()))
                .subjectDTOS(subjectMapper.toDto(student.getSubjects()))
                .addressDTO(addressMapper.toDto(student.getAddress()))
                .frist_name(student.getFirst_name())
                .last_name(student.getLast_name())
                .id(student.getId())
                .build();
        return studentDTO;
    }
    public List<StudentDTO> toDTO(List<Student> students){
        List<StudentDTO> studentDTOS=new ArrayList<>();
        students.forEach(student -> {
            StudentDTO dto = toDto(student);
            studentDTOS.add(dto);
        });
        return studentDTOS;
    }

    public  Student toEntity(StudentDTO dto){
        Student student=Student.builder()
                .id(dto.getId())
                .first_name(dto.getFrist_name()).last_name(dto.getLast_name())
                .build();
        return student;
    }

    public List<Student> toEntity(List<StudentDTO> dtos){
        List<Student> students= new ArrayList<>();
        dtos.forEach(student -> {
            Student student1= toEntity(student);
            students.add(student1);
        });
        return students;
    }

    public AddressDTO toAddress(Adress dto){
        AddressDTO adress=AddressDTO.builder().id(dto.getId()).city(dto.getCity()).name(dto.getName()).district(dto.getDistrict()).build();
        return adress;
    }
    public List<AddressDTO> toAddress(List<Adress> dtos){
        List<AddressDTO> dtos1=new ArrayList<>();
        dtos.forEach(dto -> {
            AddressDTO addressDTO=toAddress(dto);
            dtos1.add(addressDTO);
        });
        return dtos1;
    }

//    public StudentDTO toAddressHN(Student student){
//        StudentDTO studentDTO=StudentDTO.builder().addressDTO(addressMapper.toDto(student.getAdress())).frist_name(student.getFirst_name()).last_name(student.getLast_name()).id(student.getId()).build();
//        return studentDTO;
//    }
//    public List<StudentDTO> toAddressHN(List<Student> students){
//        List<StudentDTO> studentDTOS=new ArrayList<>();
//        students.forEach(student -> {
//            StudentDTO dto = toDto(student);
//            studentDTOS.add(dto);
//        });
//        return studentDTOS;
//    }

//    public StudentDTO toAddressHN(Student student){
//        StudentDTO dto=StudentDTO.builder().addressDTO(addressMapper.toDto(student.getAdress())).id(student.getId()).frist_name(student.getFirst_name()).last_name(student.getLast_name()).build();
//        return dto;
//    }
    public List<StudentDTO> toAddressHN(List<Student> students){
        List<StudentDTO> dtos=new ArrayList<>();
        students.forEach(student -> {
            StudentDTO dto=toDto(student);
            dtos.add(dto);
        });
        return dtos;
    }

    // lấy ra sinh viên học lớp DEV01
    public List<StudentDTO> toClasses(List<Student> students){
        List<StudentDTO> dtos=new ArrayList<>();
        students.forEach(student -> dtos.add(toDto(student)));
        return dtos;
    }


    public StudentDTO toDTo_sub (Student student){
        StudentDTO studentDTO=StudentDTO.builder()
                .subjectDTOS(subjectMapper.toDto(student.getSubjects()))
                .frist_name(student.getFirst_name())
                .last_name(student.getLast_name())
                .id(student.getId())
                .build();
        return studentDTO;
    }
    public List<StudentDTO> toSubject(List<Student> students){
        List<StudentDTO> dtos=new ArrayList<>();
        students.forEach(student -> dtos.add(toDTo_sub(student)));
        return dtos;
    }

    public List<StudentDTO> toPoint(List<Student> students){
        List<StudentDTO> dtos=new ArrayList<>();
        students.forEach(student -> dtos.add(toDto(student)));
        return dtos;
    }
}
