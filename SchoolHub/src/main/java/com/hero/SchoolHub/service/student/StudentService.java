package com.hero.SchoolHub.service.student;

import com.hero.SchoolHub.bo.student.CreateStudentRequest;
import com.hero.SchoolHub.bo.student.StudentResponse;

import java.util.List;

public interface StudentService {

    void save(List<CreateStudentRequest> request, String gradeName, String schoolName, String cityName);

    List<StudentResponse> getAllStudents(String gradeName, String schoolName, String cityName);
}
