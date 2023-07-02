package WeekFive.InsuranceManagementSystem.Insurances;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(){
        super("Fiat Car Insurance ", 899.99, new Date(), new Date());

    }

    @Override
    public double calculate() {
        // Perform specific calculation logic for car insurance
        // Return the calculated insurance fee
      return super.getInsuranceCost();

    }
}
