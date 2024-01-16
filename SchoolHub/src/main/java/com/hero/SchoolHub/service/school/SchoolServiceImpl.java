package com.hero.SchoolHub.service.school;

import com.hero.SchoolHub.bo.school.SchoolResponse;
import com.hero.SchoolHub.entity.SchoolEntity;
import com.hero.SchoolHub.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<SchoolResponse> getAllSchoolsByCityName(String cityName) {
        List<SchoolEntity> schoolEntities = schoolRepository.findByCityEntityCityName(cityName);
        return schoolEntities.stream()
                .map(this::convertToSchoolResponse)
                .collect(Collectors.toList());
    }

    private SchoolResponse convertToSchoolResponse(SchoolEntity schoolEntity) {
        SchoolResponse response = new SchoolResponse();
        response.setSchoolName(schoolEntity.getSchoolName());
        return response;
    }
}
