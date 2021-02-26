package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/25 11:08 上午
 */
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewStudent(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam(required = false) String gender) {
        return studentService.findAllStudent(gender);
    }

    @GetMapping({"/{id}"})
    public Student getOneStudent(@PathVariable("id") long id) {
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") long id,
                                 @RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "gender", required = false) String gender,
                                 @RequestParam(name = "note", required = false) String note) {
        return studentService.updateStudent(id, name, gender, note);
    }
}
