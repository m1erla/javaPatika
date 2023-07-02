package WeekFive.InsuranceManagementSystem.CustomerProfile;

import WeekFive.InsuranceManagementSystem.Accounter.Account;
import WeekFive.InsuranceManagementSystem.Insurances.Insurance;
import WeekFive.InsuranceManagementSystem.User;

public class Individual extends Account {
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        // Add individual-specific logic for adding insurance
        // e.g., apply profit margin to the insurance cost
        getInsuranceList().add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
