package com.hero.SchoolHub.repository;

import com.hero.SchoolHub.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity,Long> {
    Optional<CityEntity> findByCityName(String cityName);
}
