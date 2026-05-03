package com.zerobugz.lab_sample_manager.controller;

import com.zerobugz.lab_sample_manager.model.Sample;
import com.zerobugz.lab_sample_manager.service.SampleService;
import jakarta.validation.Valid;
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
    public Sample addSample(@Valid @RequestBody Sample sample){
        return sampleService.addSample(sample);

    }
    @GetMapping("/{id}")
    public Sample getById(@PathVariable Long id){
        return sampleService.getById(id);
    }

    @PutMapping("/{id}")
    public Sample updateSample(@PathVariable Long id,@Valid @RequestBody Sample sample){
        return sampleService.updateSample(id,sample);
    }
    @DeleteMapping("/{id}")
    public void deleteSample(@PathVariable Long id){
        sampleService.deleteSample(id);
    }
}


