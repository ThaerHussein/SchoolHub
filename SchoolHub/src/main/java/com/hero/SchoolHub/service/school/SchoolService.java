package com.hero.SchoolHub.service.school;

import com.hero.SchoolHub.bo.school.SchoolResponse;

import java.util.List;

public interface SchoolService {

    List<SchoolResponse> getAllSchoolsByCityName(String cityName);
}
