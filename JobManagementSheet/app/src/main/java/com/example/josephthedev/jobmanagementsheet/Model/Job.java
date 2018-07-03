package com.example.josephthedev.jobmanagementsheet.Model;

import java.util.Date;

public class Job {
    private String ref_ID;
    private String job_Type;
    private String Description;
    private Date reqDate;
    private String complexity;

    public String getRef_ID() {
        return ref_ID;
    }

    public void setRef_ID(String ref_ID) {
        this.ref_ID = ref_ID;
    }

    public String getJob_Type() {
        return job_Type;
    }

    public void setJob_Type(String job_Type) {
        this.job_Type = job_Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }
}
