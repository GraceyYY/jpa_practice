package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public void addStudent(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("sex") String sex) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        studentRepository.save(student);
    }

    @GetMapping("/students")
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id).get();
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/students")
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
