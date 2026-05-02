package com.zerobugz.lab_sample_manager.service;

import com.zerobugz.lab_sample_manager.model.Sample;
import com.zerobugz.lab_sample_manager.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class SampleService {
    @Autowired
   public SampleRepository sampleRepository;


    public List<Sample> getAllSamples() {
        return sampleRepository.findAll();
    }

    public Sample addSample(Sample sample){
        return sampleRepository.save(sample);
    }

   public Sample getById(Long id){
        return sampleRepository.findById(id).orElse(null);
   }


   public Sample updateSample(Long id,Sample updatedSample){
       Sample alteredSample = sampleRepository.findById(id).orElse(null);
       assert alteredSample != null;
       alteredSample.setName(updatedSample.getName());
       alteredSample.setPurpose(updatedSample.getPurpose());
       alteredSample.setStatus(updatedSample.getStatus());

       return sampleRepository.save(alteredSample);
   }

    public void deleteSample(Long id){
        sampleRepository.deleteById(id);
    }
}