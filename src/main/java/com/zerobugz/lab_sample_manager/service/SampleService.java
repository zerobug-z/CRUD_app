package com.zerobugz.lab_sample_manager.service;

import com.zerobugz.lab_sample_manager.model.Sample;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SampleService {

   private List<Sample> samples = new ArrayList<Sample>();
    private long counter = 1;

    public List<Sample> getAllSamples(){
        return samples;
    }


    public Sample addSample(Sample sample){
        sample.setId(counter);
        counter ++;
        samples.add(sample);
        return sample;
    }
}
