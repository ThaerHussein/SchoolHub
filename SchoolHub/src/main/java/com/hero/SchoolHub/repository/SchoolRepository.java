package com.hero.SchoolHub.repository;

import com.hero.SchoolHub.entity.CityEntity;
import com.hero.SchoolHub.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity,Long> {
    Optional<SchoolEntity> findBySchoolName(String schoolName);
    List<SchoolEntity> findByCityEntityCityName(String cityName);

    Optional<SchoolEntity> findBySchoolNameAndCityEntity(String schoolName, CityEntity cityEntity);
}
