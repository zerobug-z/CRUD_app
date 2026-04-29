package com.zerobugz.lab_sample_manager.service;

import com.zerobugz.lab_sample_manager.model.Sample;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SampleService {

    private List<Sample> samples = new ArrayList<Sample>();
    private long counter = 1;

    public List<Sample> getAllSamples() {
        return samples;
    }


    public Sample addSample(Sample sample) {
        sample.setId(counter);
        counter++;
        samples.add(sample);
        return sample;
    }

    public Sample getById(Long id) {
        Sample foundSample= null;
        for (Sample sample: samples
             ) {
            if(sample.getId().equals(id)){
                foundSample = sample;
                break;
            }
        }
        return foundSample;
    }

    public Sample updateSample(Long id, Sample updatedSample){
        Sample alteredSample = null;
        for (Sample sample: samples
             ) {
            if(sample.getId().equals(id)){
                sample.setName(updatedSample.getName());
                sample.setPurpose(updatedSample.getPurpose());
                sample.setStatus(updatedSample.getStatus());
                alteredSample=sample;
                break;
            }
        }
        return alteredSample;
    }
    public void deleteSample(Long id){
        for (Sample sample: samples
             ) {
            if(sample.getId().equals(id)){
                samples.remove(sample);
                break;
            }
        }
    }
}