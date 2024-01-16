package com.hero.SchoolHub.service.grade;

import com.hero.SchoolHub.bo.grade.CreateGradeRequest;
import com.hero.SchoolHub.bo.grade.GradeResponse;

import java.util.List;

public interface GradeService {

    void save(CreateGradeRequest request);

    List<GradeResponse> getGradesBySchoolAndCityName(String schoolName, String cityName);
}
