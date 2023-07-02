package WeekFive.InsuranceManagementSystem.CustomerProfile;

import WeekFive.InsuranceManagementSystem.Accounter.Account;
import WeekFive.InsuranceManagementSystem.Insurances.HealthInsurance;
import WeekFive.InsuranceManagementSystem.Insurances.Insurance;
import WeekFive.InsuranceManagementSystem.User;

import java.util.Scanner;

public class Enterprise extends Account {
    private final String enterprise = "Enterprise";
    public Enterprise(User user){
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance){
        Scanner input = new Scanner(System.in);
        // Add enterprise-specific logic for adding insurance
        // e.g., apply different profit margin to the insurance cost
        System.out.println("Insurance Types ");
        System.out.println("1 - Health Insurance " + "\t 2 - Car Insurance " + "\t 3 - Residence Insurance "
                + "\t 4 - Travel Insurance ");
        System.out.print("Select a insurance type you want to do : ");
        int choice = input.nextInt();
        switch (choice){
            case 1 :
                if (isInsurance(new HealthInsurance())){
                  setInsurance(new HealthInsurance());
                    System.out.println("Success for insurance process!");
                }else {
                    System.out.println("You have already this insurance!");
                }
                break;
        }
    }
    private boolean isInsurance(Insurance insurance){
        for (Insurance i : getInsuranceList()){
            if (i.getFuseName().equals(insurance.getFuseName())){
                return false;
            }
        }
        return true;
    }
    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
