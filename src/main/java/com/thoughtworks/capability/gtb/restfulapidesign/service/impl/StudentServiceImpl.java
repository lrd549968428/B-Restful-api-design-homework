package com.thoughtworks.capability.gtb.restfulapidesign.service.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/25 9:37 上午
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudent(String gender) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> null == gender || student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    @Override
    public Student updateStudent(long id, String name, String gender, String note) {
        Student student = Student.builder()
                .id(id)
                .name(name)
                .gender(gender)
                .note(note)
                .build();
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

}
