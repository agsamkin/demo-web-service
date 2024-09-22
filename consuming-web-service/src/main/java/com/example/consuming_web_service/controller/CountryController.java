package com.example.consuming_web_service.controller;

import com.example.consuming_web_service.client.CountryClient;
import com.example.consuming_web_service.wsdl.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryClient countryClient;

    @GetMapping
    public Country getAllMetrics(@RequestParam(value = "name") String name) {
        return countryClient.getCountry(name).getCountry();
    }

}
