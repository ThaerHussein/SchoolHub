package com.hero.SchoolHub.school;

import com.hero.SchoolHub.bo.school.SchoolResponse;
import com.hero.SchoolHub.entity.CityEntity;
import com.hero.SchoolHub.entity.SchoolEntity;
import com.hero.SchoolHub.repository.SchoolRepository;
import com.hero.SchoolHub.service.school.SchoolServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SchoolServiceImplTest {

    @Mock
    private SchoolRepository schoolRepository;

    @InjectMocks
    private SchoolServiceImpl schoolService;

    @Test
    public void testGetAllSchoolsByCityName() {
        when(schoolRepository.findByCityEntityCityName("City1"))
                .thenReturn(Collections.singletonList(new SchoolEntity(1L, "School1", new CityEntity(1L, "City1", null, null), null, null)));

        List<SchoolResponse> responses = schoolService.getAllSchoolsByCityName("City1");

        assertFalse(responses.isEmpty());
        assertEquals("School1", responses.get(0).getSchoolName());
    }
}