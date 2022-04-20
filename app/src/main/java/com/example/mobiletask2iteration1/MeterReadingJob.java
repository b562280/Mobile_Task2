package com.example.mobiletask2iteration1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MeterReadingJob implements Serializable {
    private Integer ID;
    private Integer typeOfMeter; // 0 - Gas, 1 - Electric, 3 - Solar
    private Date DeadlineDate;
    private String JobAddress;
    private String MeterLocation;
    private String UtilityCompany;
    private Boolean JobStatus;
    private String NameOfCustomer;

    private String MeterReadingResult;

    public MeterReadingJob(Integer JobID, Integer typeOfMeter, Date deadlineDate, String jobAddress, String meterLocation, String utilityCompany, Boolean jobStatus, String nameOfCustomer) {
        ID = JobID;
        this.typeOfMeter = typeOfMeter;
        this.DeadlineDate = deadlineDate;
        this.JobAddress = jobAddress;
        this.MeterLocation = meterLocation;
        this.UtilityCompany = utilityCompany;
        this.JobStatus = jobStatus;
        this.NameOfCustomer = nameOfCustomer;
    }

    public String getID() {
        return ID.toString();
    }

    public String getDeadlineDate() {
        SimpleDateFormat ft = new SimpleDateFormat ("E dd/MM/yyyy");
        return ft.format(DeadlineDate);
    }

    public String getTypeOfMeter() {
        String OutputSting ="";
        switch (typeOfMeter){
            case 0:
                OutputSting = "Gas";
            case 1:
                OutputSting = "Electric";
            case 2:
                OutputSting = "Solar";
        }
        return OutputSting;
    }

    public String getJobAddress() {
        return JobAddress;
    }

    public String getMeterLocation() {
        return MeterLocation;
    }

    public String getUtilityCompany() {
        return UtilityCompany;
    }

    public String getNameOfCustomer() {
        return NameOfCustomer;
    }

    public Boolean getJobStatus() {
        return JobStatus;
    }

    public void setJobStatus(Boolean inputJobStatus) {
        JobStatus = inputJobStatus;
    }

    public void  setID (Integer id) {
        ID = id;
    }

    public String getMeterReadingResult() {
        return MeterReadingResult;
    }

    public void setMeterReadingResult(String meterReadingResult) {
        MeterReadingResult = meterReadingResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeterReadingJob that = (MeterReadingJob) o;
        return Objects.equals(ID, that.ID) && Objects.equals(typeOfMeter, that.typeOfMeter) && Objects.equals(DeadlineDate, that.DeadlineDate) && Objects.equals(JobAddress, that.JobAddress) && Objects.equals(MeterLocation, that.MeterLocation) && Objects.equals(UtilityCompany, that.UtilityCompany) && Objects.equals(JobStatus, that.JobStatus) && Objects.equals(NameOfCustomer, that.NameOfCustomer) && Objects.equals(MeterReadingResult, that.MeterReadingResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, typeOfMeter, DeadlineDate, JobAddress, MeterLocation, UtilityCompany, JobStatus, NameOfCustomer, MeterReadingResult);
    }
}
