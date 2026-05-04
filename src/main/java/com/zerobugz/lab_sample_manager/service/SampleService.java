package com.zerobugz.lab_sample_manager.service;

import com.zerobugz.lab_sample_manager.dto.SampleRequestDTO;
import com.zerobugz.lab_sample_manager.dto.SampleResponseDTO;
import com.zerobugz.lab_sample_manager.model.Sample;
import com.zerobugz.lab_sample_manager.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class SampleService {
    @Autowired
   private SampleRepository sampleRepository;


    public List<SampleResponseDTO> getAllSamples() {
        return sampleRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private SampleResponseDTO toResponseDTO(Sample sample){
        SampleResponseDTO dto = new SampleResponseDTO();
        dto.setId(sample.getId());
        dto.setName(sample.getName());
        dto.setPurpose(sample.getPurpose());
        dto.setStatus(sample.getStatus());
        return dto;
    }

    public SampleResponseDTO addSample(SampleRequestDTO dto ){
        Sample sample = new Sample();
        sample.setName(dto.getName());
        sample.setStatus(dto.getStatus());
        sample.setPurpose(dto.getPurpose());

        return toResponseDTO(sampleRepository.save(sample));
    }

   public SampleResponseDTO getById(Long id){

        return sampleRepository.findById(id).map(this::toResponseDTO).orElse(null);
   }

   public SampleResponseDTO updateSample(SampleRequestDTO dto,Long id){

       Sample alteredSample = sampleRepository.findById(id).orElse(null);
       assert alteredSample != null;
       alteredSample.setName(dto.getName());
       alteredSample.setPurpose(dto.getPurpose());
       alteredSample.setStatus(dto.getStatus());

       return toResponseDTO(sampleRepository.save(alteredSample));
   }

    public void deleteSample(Long id){
        sampleRepository.deleteById(id);
    }
}