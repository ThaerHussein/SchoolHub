package com.hero.SchoolHub.city;

import com.hero.SchoolHub.bo.city.CityResponse;
import com.hero.SchoolHub.entity.CityEntity;
import com.hero.SchoolHub.repository.CityRepository;
import com.hero.SchoolHub.service.city.CityServiceImpl;
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
public class CityServiceImplTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    public void testGetAllCities() {
        when(cityRepository.findAll()).thenReturn(Collections.singletonList(new CityEntity(1L, "City1", null, null)));

        List<CityResponse> responses = cityService.getAllCities();

        assertFalse(responses.isEmpty());
        assertEquals("City1", responses.get(0).getCityName());
    }
}