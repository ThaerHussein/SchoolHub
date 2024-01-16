package com.hero.SchoolHub.repository;

import com.hero.SchoolHub.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity,Long> {

    List<GradeEntity> findBySchoolSchoolNameAndSchoolCityEntityCityName(String schoolName, String cityName);

    Optional<GradeEntity> findByGradeNameAndSchoolSchoolNameAndSchoolCityEntityCityName(String gradeName, String schoolName, String cityName);
}
