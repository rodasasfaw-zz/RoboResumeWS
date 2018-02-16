package com.roboresumews.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String jobTitle;

    public Experience() {
    }

    private String company;
    private String duty;
    private String beginyear;
    private String endyear;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getBeginyear() {
        return beginyear;
    }

    public void setBeginyear(String beginyear) {
        this.beginyear = beginyear;
    }

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public Experience(String company, String duty, String beginyear, String endyear) {
        this.company = company;
        this.duty = duty;
        this.beginyear = beginyear;
        this.endyear = endyear;

    }
}
