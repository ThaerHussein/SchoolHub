package com.hero.SchoolHub.repository;

import com.hero.SchoolHub.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findAllByGradeGradeNameAndGradeSchoolSchoolNameAndGradeSchoolCityEntityCityName(
            String gradeName, String schoolName, String cityName);
}
