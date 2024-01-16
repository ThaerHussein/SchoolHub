package com.hero.SchoolHub.service.city;

import com.hero.SchoolHub.bo.city.CityResponse;
import com.hero.SchoolHub.entity.CityEntity;
import com.hero.SchoolHub.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Override
    public List<CityResponse> getAllCities() {
        List<CityEntity> cities = cityRepository.findAll();
        return cities.stream()
                .map(this::convertToCityResponse)
                .collect(Collectors.toList());
    }

    private CityResponse convertToCityResponse(CityEntity city) {
        CityResponse response = new CityResponse();
        response.setCityName(city.getCityName());
        return response;
    }
}
