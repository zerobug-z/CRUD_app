package com.zerobugz.lab_sample_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank private String name;
    @NotBlank private String status;
    @NotBlank private String purpose;

    public Sample(){};

    public Sample(Long id,String name,String status,String purpose){
        this.id=id;
        this.name=name;
        this.purpose=purpose;
        this.status=status;
    }
    //Field encapsulations
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getPurpose(){
        return purpose;
    }
    public void setPurpose(String purpose){
        this.purpose = purpose;
    }


}
