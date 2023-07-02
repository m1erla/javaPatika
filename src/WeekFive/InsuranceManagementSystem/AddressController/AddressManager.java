package WeekFive.InsuranceManagementSystem.AddressController;

import WeekFive.InsuranceManagementSystem.User;

public class AddressManager {


    public static void addAddress(User user, Address address) {
        User.addAddress(user, address);
    }

    public static void removeAddress(User user, Address address) {
        User.removeAddress(user, address);
    }

}
