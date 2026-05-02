package com.zerobugz.lab_sample_manager.repository;

import com.zerobugz.lab_sample_manager.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
