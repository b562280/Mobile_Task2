package com.example.mobiletask2iteration1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MeterReadingJob implements Serializable {
    private Integer ID;
    private Integer typeOfMeter; // 0 - Gas, 1 - Electric, 2 - Solar
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

    // Getters
    public String getID() {
        return ID.toString();
    }

    public Integer getTypeOfMeter() { return typeOfMeter; }

    public String getJobAddress() {
        return JobAddress;
    }

    public String getMeterLocation() { return MeterLocation;}

    public String getUtilityCompany() {
        return UtilityCompany;
    }

    public String getNameOfCustomer() {
        return NameOfCustomer;
    }

    public Boolean getJobStatus() {
        return JobStatus;
    }

    public String getMeterReadingResult() {
        return MeterReadingResult;
    }

    public Date getDeadlineDate() { return DeadlineDate; }

    public String getDeadlineDate_toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return ft.format(DeadlineDate);
    }

    /**
     * This will return the typeOfMeter as a string
     * 0 - Gas,
     * 1 - Electric,
     * 2 - Solar,
     * @return String
     */
    public String getMeterType_String() {
        String output = "";
        switch (typeOfMeter) {
            case(0):
                output = "Gas";
                break;
            case(1):
                output = "Electric";
                break;
            case(2):
                output = "Solar";
                break;
        }
        return output;
    }

    // Setters
    public void setJobStatus(Boolean inputJobStatus) {
        JobStatus = inputJobStatus;
    }

    public void setMeterType(Integer type) { typeOfMeter = type;  }

    public void setAddress(String Address) { JobAddress = Address;}

    public void setUtilComp(String UtilComp) { UtilityCompany = UtilComp;}

    public void setMeterLocation(String MeterLoc) { MeterLocation = MeterLoc;}

    public void setCustomerName(String toString) { NameOfCustomer = toString;}

    public void setMeterReadingResult(String meterReadingResult) {
        MeterReadingResult = meterReadingResult;}

    public void setDeadlineDate_String(String Date){
        try {
            DeadlineDate = new SimpleDateFormat("dd/MM/yyyy").parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeterReadingJob that = (MeterReadingJob) o;
        return Objects.equals(ID, that.ID) && Objects.equals(typeOfMeter, that.typeOfMeter) && Objects.equals(DeadlineDate, that.DeadlineDate) && Objects.equals(JobAddress, that.JobAddress) && Objects.equals(MeterLocation, that.MeterLocation) && Objects.equals(UtilityCompany, that.UtilityCompany) && Objects.equals(JobStatus, that.JobStatus) && Objects.equals(NameOfCustomer, that.NameOfCustomer) && Objects.equals(MeterReadingResult, that.MeterReadingResult);
    }

    @Override
    public String toString() {
        return  "ID : " + ID + "\n" +
                "Meter Type : " + getMeterType_String() + "\n" +
                "Deadline Date : " + getDeadlineDate_toString() + "\n" +
                "Address of Job : " + JobAddress + "\n" +
                "Location of Meter : " + MeterLocation + "\n" +
                "Utility Company : " + UtilityCompany + "\n" +
                "Customer Name : " + NameOfCustomer + "\n" +
                "Result of Meter Reading : " + MeterReadingResult + "\n";
    }
}
