package WeekFive.InsuranceManagementSystem.Insurances;

import java.time.Instant;
import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance() {
        super("Allianz Health Insurance " , 1299.99, new Date(), new Date());

    }

    @Override
    public double calculate() {
        // Perform specific calculation logic for health insurance
        // Return the calculated insurance fee
        return super.getInsuranceCost();
    }
}
