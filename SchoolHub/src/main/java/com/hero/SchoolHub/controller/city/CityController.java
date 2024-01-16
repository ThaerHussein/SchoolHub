package com.hero.SchoolHub.controller.city;

import com.hero.SchoolHub.bo.city.CityResponse;
import com.hero.SchoolHub.service.city.CityService;
import com.hero.SchoolHub.util.response.CODE;
import com.hero.SchoolHub.util.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<Response<List<CityResponse>>> getAllCities() {
        Response<List<CityResponse>> response = Response.<List<CityResponse>>builder()
                .data(cityService.getAllCities())
                .code(CODE.OK.getId())
                .message(CODE.OK.name())
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
