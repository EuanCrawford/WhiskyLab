package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity getWhiskyByYear(@RequestParam(name="year") int year) {
        return new ResponseEntity(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleries")
    public ResponseEntity getWhiskyByDistilleryAndAge(
            @RequestParam(name = "distillery_name") String distillery_name,
            @RequestParam(name = "age") int age ) {
        return new ResponseEntity(whiskyRepository.findByAgeAndDistilleryName(age, distillery_name), HttpStatus.OK);
    }
}
