package com.hero.SchoolHub.service.grade;

import com.hero.SchoolHub.bo.grade.CreateGradeRequest;
import com.hero.SchoolHub.bo.grade.GradeResponse;
import com.hero.SchoolHub.entity.CityEntity;
import com.hero.SchoolHub.entity.GradeEntity;
import com.hero.SchoolHub.entity.SchoolEntity;
import com.hero.SchoolHub.repository.CityRepository;
import com.hero.SchoolHub.repository.GradeRepository;
import com.hero.SchoolHub.repository.SchoolRepository;
import com.hero.SchoolHub.util.validators.validators.CompositeValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.hero.SchoolHub.util.validators.validators.CompositeValidator.hasValue;
import static com.hero.SchoolHub.util.validators.validators.ValidationUtils.validate;

@Service
public class GradeServiceImpl implements GradeService {

    private final CityRepository cityRepository;
    private final GradeRepository gradeRepository;
    private final SchoolRepository schoolRepository;

    public GradeServiceImpl(CityRepository cityRepository, GradeRepository gradeRepository, SchoolRepository schoolRepository) {
        this.cityRepository = cityRepository;
        this.gradeRepository = gradeRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    @Transactional
    public void save(CreateGradeRequest request) {
        createPreValidation(request);
        CityEntity cityEntity = getExistingCityOrCreateNew(request.getCityName());
        SchoolEntity schoolEntity = getExistingSchoolOrCreateNew(request.getSchoolName(), cityEntity);
        createGrade(request, schoolEntity);
    }

    @Override
    public List<GradeResponse> getGradesBySchoolAndCityName(String schoolName, String cityName) {
        List<GradeEntity> gradeEntities = gradeRepository.findBySchoolSchoolNameAndSchoolCityEntityCityName(schoolName, cityName);
        return gradeEntities.stream()
                .map(this::convertToGradeResponse)
                .collect(Collectors.toList());
    }


    private GradeResponse convertToGradeResponse(GradeEntity gradeEntity) {
        GradeResponse response = new GradeResponse();
        response.setGradeName(gradeEntity.getGradeName());
        response.setNumberOfStudents(gradeEntity.getNumberOfStudents());
        return response;
    }

    private void createGrade(CreateGradeRequest request, SchoolEntity schoolEntity) {
        gradeRepository.save(GradeEntity.builder()
                .gradeName(request.getGradeName())
                .school(schoolEntity)
                .numberOfStudents(request.getNumberOfStudent())
                .creationDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    private SchoolEntity getExistingSchoolOrCreateNew(String schoolName, CityEntity cityEntity) {
        return schoolRepository
                .findBySchoolNameAndCityEntity(schoolName, cityEntity)
                .orElseGet(() -> createSchool(schoolName, cityEntity));
    }

    private SchoolEntity createSchool(String schoolName, CityEntity cityEntity) {
        return schoolRepository.save(SchoolEntity.builder()
                .cityEntity(cityEntity)
                .schoolName(schoolName)
                .creationDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    private CityEntity getExistingCityOrCreateNew(String cityName) {
        return cityRepository.findByCityName(cityName)
                .orElseGet(() -> createCity(cityName));
    }

    private CityEntity createCity(String cityName) {
        return cityRepository.save(CityEntity.builder()
                .cityName(cityName)
                .creationDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    public void createPreValidation(CreateGradeRequest createDto) {
        List<String> violations = new CompositeValidator<CreateGradeRequest, String>()
                .addValidator(r -> hasValue(r.getCityName()), "City name field cannot be empty")
                .addValidator(r -> hasValue(r.getSchoolName()), "School name field cannot be empty")
                .addValidator(r -> hasValue(r.getGradeName()), "Grade name field cannot be empty")
                .addValidator(r -> hasValue(r.getNumberOfStudent()), "Number Of Student field cannot be empty")
                .addValidator(r -> Pattern.compile("^[0-9]+$").matcher(r.getNumberOfStudent()).matches(), "Number Of Student field should be just numbers")
                .validate(createDto);
        validate(violations);
    }
}
