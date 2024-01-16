package com.hero.SchoolHub.controller.grade;

import com.hero.SchoolHub.bo.grade.CreateGradeRequest;
import com.hero.SchoolHub.bo.grade.GradeResponse;
import com.hero.SchoolHub.service.grade.GradeService;
import com.hero.SchoolHub.util.response.CODE;
import com.hero.SchoolHub.util.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grade")
public class GradeController {
    private final GradeService gradeService;


    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/by-school-and-city")
    public ResponseEntity<Response<List<GradeResponse>>> getGradesBySchoolAndCityName(
            @RequestParam String schoolName,
            @RequestParam String cityName) {
        Response<List<GradeResponse>> response = Response.<List<GradeResponse>>builder()
                .data(gradeService.getGradesBySchoolAndCityName(schoolName, cityName))
                .code(CODE.OK.getId())
                .message(CODE.OK.name())
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Response<Void>> createGrade(@RequestBody CreateGradeRequest request) {
        gradeService.save(request);
        Response<Void> response = Response.<Void>builder()
                .data(null)
                .success(true)
                .code(CODE.OK.getId())
                .message(CODE.OK.name()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
