package com.zerobugz.lab_sample_manager.model;

public class Sample {
    private Long id;
    private String name;
    private String status;
    private String purpose;

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
