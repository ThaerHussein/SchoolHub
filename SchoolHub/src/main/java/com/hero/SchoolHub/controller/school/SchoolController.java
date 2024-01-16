package com.hero.SchoolHub.controller.school;

import com.hero.SchoolHub.bo.school.SchoolResponse;
import com.hero.SchoolHub.service.school.SchoolService;
import com.hero.SchoolHub.util.response.CODE;
import com.hero.SchoolHub.util.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    private final SchoolService schoolService;


    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/by-city")
    public ResponseEntity<Response<List<SchoolResponse>>> getAllSchoolsByCityName(@RequestParam String cityName) {
        Response<List<SchoolResponse>> response = Response.<List<SchoolResponse>>builder()
                .data(schoolService.getAllSchoolsByCityName(cityName))
                .code(CODE.OK.getId())
                .message(CODE.OK.name())
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
