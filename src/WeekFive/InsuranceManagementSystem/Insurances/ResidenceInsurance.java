package WeekFive.InsuranceManagementSystem.Insurances;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String fuseName, double insuranceCost, Date startDate, Date endDate) {
        super("Residence Insurance", 4599.99, new Date(), new Date());
    }
    @Override
    public double calculate() {
        // Perform specific calculation logic for residence insurance
        // Return the calculated insurance fee
        return super.getInsuranceCost();
    }
}
