package com.zerobugz.lab_sample_manager.controller;

import com.zerobugz.lab_sample_manager.dto.SampleRequestDTO;
import com.zerobugz.lab_sample_manager.dto.SampleResponseDTO;
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
    public List<SampleResponseDTO> getAllSamples(){
        return sampleService.getAllSamples();
    }

    @PostMapping
    public SampleResponseDTO addSample(@Valid @RequestBody SampleRequestDTO sample){
        return sampleService.addSample(sample);

    }
    @GetMapping("/{id}")
    public SampleResponseDTO getById(@PathVariable Long id){
        return sampleService.getById(id);
    }

    @PutMapping("/{id}")
    public SampleResponseDTO updateSample(@PathVariable Long id,@RequestBody SampleRequestDTO sample){
        return sampleService.updateSample(sample,id);
    }
    @DeleteMapping("/{id}")
    public void deleteSample(@PathVariable Long id){
        sampleService.deleteSample(id);
    }
}
