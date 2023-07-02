package WeekFive.InsuranceManagementSystem;

import WeekFive.InsuranceManagementSystem.Accounter.Account;
import WeekFive.InsuranceManagementSystem.Accounter.AccountManager;
import WeekFive.InsuranceManagementSystem.AddressController.Address;
import WeekFive.InsuranceManagementSystem.CustomerProfile.Enterprise;
import WeekFive.InsuranceManagementSystem.CustomerProfile.Individual;
import WeekFive.InsuranceManagementSystem.Exception.InvalidAuthenticationException;
import WeekFive.InsuranceManagementSystem.Insurances.HealthInsurance;
import WeekFive.InsuranceManagementSystem.Insurances.Insurance;

import java.util.Scanner;

public class InputCredentials {
    private Insurance insurance;
    static Scanner input = new Scanner(System.in);
    public static void runner() throws InvalidAuthenticationException {


        // Create AccountManager and add some accounts

        AccountManager accountManager = new AccountManager();
        User user3 = new User("Emily Jean", "Stone", "emmastone88@gmail.com", "losAngeles1988","Actor",33);
        Individual individual3 = new Individual(user3);
        accountManager.addAccount();

        User user2 = new User("Tom", "Hardy", "tomhardy85@hotmail.com", "venomtom85","Actor", 38);
        Enterprise enterprise1 = new Enterprise(user2);
        accountManager.addAccount();
        // Retrieve email and password from the keyboard
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        // Call login function in AccountManager

                Account account = accountManager.login(email, password);
                if (account != null){
                    System.out.println("Login successful!");
                    account.showUserInfo();


                    // Do something with the logged-in account
                }else {
                    System.out.println("Login failed!");
                }


            while (true){
                System.out.println("Transaction List ");
                System.out.println("1 - Show User Information\n " +
                        "2 - Do a new policy to user \n "+
                        "3 - Add a new address to user\n "+
                        "4 - Delete a user address\n " +
                        "0 - Exit the panel ! ");

                System.out.print("Choose a transaction you want to do : ");
                int choice = input.nextInt();
                switch (choice){
                    case 1 :
                        account.showUserInfo();
                        break;
                    case 2 :

                        break;
                }
            }
    }

}
