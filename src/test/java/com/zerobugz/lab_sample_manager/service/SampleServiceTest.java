package com.zerobugz.lab_sample_manager.service;

import com.zerobugz.lab_sample_manager.dto.SampleRequestDTO;
import com.zerobugz.lab_sample_manager.model.Sample;
import com.zerobugz.lab_sample_manager.repository.SampleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SampleServiceTest {

    @Mock SampleRepository sampleRepository;
    @InjectMocks SampleService sampleService;

    @Test
    public void getAllSamples(){
        List<Sample> samples = new ArrayList<Sample>();
        Sample sample1 = new Sample(1L,"blood","collected","blood test");
        Sample sample2 = new Sample(2L,"saliva","examined","saliva test");
        Sample sample3 = new Sample(3L,"hair","examined","hair test");

        samples.add(sample1);
        samples.add(sample2);
        samples.add(sample3);

        when(sampleRepository.findAll()).thenReturn(samples);

        Assertions.assertEquals(3,sampleService.getAllSamples().size());
    }


    SampleRequestDTO dto = new SampleRequestDTO();

    @Test
    public void addSample(){
        Sample sample = new Sample();

        sample.setName("blood");
        sample.setStatus("collected");
        sample.setPurpose("blood test");

        dto.setName(sample.getName());
        dto.setPurpose(sample.getPurpose());
        dto.setStatus(sample.getStatus());



        when(sampleRepository.save(any())).thenReturn(sample);
        Assertions.assertEquals("blood",sampleService.addSample(dto).getName());
    }

    @Test
    public void deleteSample(){
        sampleService.deleteSample(1L);
        verify(sampleRepository).deleteById(1L);
    }
}
