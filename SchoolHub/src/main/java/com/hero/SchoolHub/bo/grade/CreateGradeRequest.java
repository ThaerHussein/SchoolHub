package com.hero.SchoolHub.bo.grade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGradeRequest {

    private String cityName;

    private String schoolName;

    private String gradeName;

    private String numberOfStudent;
}
