package com.hero.SchoolHub.controller.student;

import com.hero.SchoolHub.bo.student.CreateStudentRequest;
import com.hero.SchoolHub.bo.student.StudentResponse;
import com.hero.SchoolHub.service.student.StudentService;
import com.hero.SchoolHub.util.response.CODE;
import com.hero.SchoolHub.util.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Response<Void>> saveStudents(@RequestBody List<CreateStudentRequest> studentRequests,
                                                 @RequestParam String gradeName,
                                                       @RequestParam String schoolName,
                                                       @RequestParam String cityName) {
        studentService.save(studentRequests, gradeName, schoolName, cityName);
        Response<Void> response = Response.<Void>builder()
                .data(null)
                .success(true)
                .code(CODE.OK.getId())
                .message(CODE.OK.name()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-grade-school-and-city")
    public ResponseEntity<Response<List<StudentResponse>>> getAllStudentsByGradeAndSchoolName(
            @RequestParam String gradeName,
            @RequestParam String schoolName,
            @RequestParam String cityName) {
        Response<List<StudentResponse>> response = Response.<List<StudentResponse>>builder()
                .data(studentService.getAllStudents(gradeName, schoolName, cityName))
                .code(CODE.OK.getId())
                .message(CODE.OK.name())
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
