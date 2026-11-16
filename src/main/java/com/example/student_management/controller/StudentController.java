package com.example.student_management.controller;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Display all students
    @GetMapping("/students")
    public String getAllStudents(Model model) {

        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students", students);
        model.addAttribute("student", new Student());

        return "index";
    }

    // Add a new student
    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student) {

        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {

        studentService.deleteStudent(id);

        return "redirect:/students";
    }

    // Display edit form
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {

        Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "edit";
    }

    // Update student
    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute Student student) {

        student.setId(id);

        studentService.saveStudent(student);

        return "redirect:/students";
    }
}