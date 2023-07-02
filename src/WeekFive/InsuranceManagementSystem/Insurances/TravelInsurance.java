package WeekFive.InsuranceManagementSystem.Insurances;

import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String fuseName, double insuranceCost, Date startDate, Date endDate){
        super("Travel Insurance ", 344.44, new Date(), new Date());
    }
    @Override
    public double calculate(){
        // Perform specific calculation logic for travel insurance
        // Return the calculated insurance fee
        return super.getInsuranceCost();
    }
}
