package com.hero.SchoolHub.student;

import com.hero.SchoolHub.bo.student.CreateStudentRequest;
import com.hero.SchoolHub.entity.GradeEntity;
import com.hero.SchoolHub.repository.GradeRepository;
import com.hero.SchoolHub.repository.StudentRepository;
import com.hero.SchoolHub.service.student.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void testSave() {
        String gradeName = "Grade1";
        String schoolName = "School1";
        String cityName = "City";
        GradeEntity grade = new GradeEntity(1L, gradeName, null, "30", null, null);
        when(gradeRepository.findByGradeNameAndSchoolSchoolNameAndSchoolCityEntityCityName(gradeName, schoolName,cityName)).thenReturn(Optional.of(grade));

        CreateStudentRequest studentRequest = new CreateStudentRequest();
        studentRequest.setStudentName("Thaer Hussein");
        studentService.save(Collections.singletonList(studentRequest), gradeName, schoolName,cityName);

        verify(studentRepository, times(1)).saveAll(anyList());
    }
}