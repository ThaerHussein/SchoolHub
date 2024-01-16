package com.hero.SchoolHub.grade;

import com.hero.SchoolHub.bo.grade.CreateGradeRequest;
import com.hero.SchoolHub.entity.CityEntity;
import com.hero.SchoolHub.entity.GradeEntity;
import com.hero.SchoolHub.entity.SchoolEntity;
import com.hero.SchoolHub.repository.CityRepository;
import com.hero.SchoolHub.repository.GradeRepository;
import com.hero.SchoolHub.repository.SchoolRepository;
import com.hero.SchoolHub.service.grade.GradeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GradeServiceImplTest {

    @Mock
    private GradeRepository gradeRepository;
    @Mock
    private SchoolRepository schoolRepository;
    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private GradeServiceImpl gradeService;

    @Test
    public void testSave() {
        CreateGradeRequest request = new CreateGradeRequest();
        request.setCityName("City1");
        request.setSchoolName("School1");
        request.setGradeName("Grade1");
        request.setNumberOfStudent("10");

        when(cityRepository.findByCityName(anyString())).thenReturn(Optional.empty());
        when(schoolRepository.findBySchoolName(anyString())).thenReturn(Optional.empty());

        gradeService.save(request);


        verify(cityRepository, times(1)).save(any(CityEntity.class));
        verify(schoolRepository, times(1)).save(any(SchoolEntity.class));
        verify(gradeRepository, times(1)).save(any(GradeEntity.class));
    }
}