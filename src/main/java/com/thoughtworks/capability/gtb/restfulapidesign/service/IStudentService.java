package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;

import java.util.List;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/25 9:37 上午
 */
public interface IStudentService {
    void addNewStudent(Student students);

    void deleteStudent(long id);

    List<Student> findAllStudent(String gender);

    Student updateStudent(long id, String name, String gender, String note);

    Student findStudentById(long id);
}
