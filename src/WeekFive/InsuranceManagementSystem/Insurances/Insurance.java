package WeekFive.InsuranceManagementSystem.Insurances;

import WeekFive.InsuranceManagementSystem.InputCredentials;
import WeekFive.InsuranceManagementSystem.User;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Insurance {
    Calendar calendar = Calendar.getInstance();
private String fuseName;
private double insuranceCost;
private Date startDate;
private Date endDate;
private Insurance insurance;

    public Insurance(String fuseName, double insuranceCost, Date startDate, Date endDate) {
        this.fuseName = fuseName;
        this.insuranceCost = insuranceCost;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Insurance chooseInsurance(User user){
        Scanner input = new Scanner(System.in);
        System.out.print("Select one of those Insurance : ");
        System.out.println("1 - Health Insurance " + "\t 2 - Car Insurance " + "\t 3 - Residence Insurance "
        + "\t 4 - Travel Insurance ");
        String choice = input.nextLine();
        System.out.println("Enter amount : ");
        int cost = input.nextInt();

 return null;
    }

    public String getFuseName() {
        return fuseName;
    }

    public void setFuseName(String fuseName) {
        this.fuseName = fuseName;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public abstract  double calculate();

    public String info(){
        return "< Insurance -{ " +
                "Name -> " + fuseName +
                "- Cost -> " + insuranceCost +
                "- Start Date -> " + startDate +
                "- End Date -> " + endDate + " > ";
    }
    public void setInsurance(Insurance insurance){
        insurance = insurance;
    }

    public Insurance getInsurance(){
        return insurance;
    }
}
