package com.zerobugz.lab_sample_manager.controller;

import com.zerobugz.lab_sample_manager.model.Sample;
import com.zerobugz.lab_sample_manager.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/samples")

public class SampleController {


    @Autowired
private SampleService sampleService;

    @GetMapping
    public List<Sample> getAllSamples(){
        return sampleService.getAllSamples();
    }

    @PostMapping
    public Sample addSample(@RequestBody Sample sample){
        return sampleService.addSample(sample);

    }
}


