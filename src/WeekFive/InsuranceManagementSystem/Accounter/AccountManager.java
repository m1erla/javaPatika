package WeekFive.InsuranceManagementSystem.Accounter;

import WeekFive.InsuranceManagementSystem.AddressController.Address;
import WeekFive.InsuranceManagementSystem.AddressController.HomeAddress;
import WeekFive.InsuranceManagementSystem.CustomerProfile.Enterprise;
import WeekFive.InsuranceManagementSystem.CustomerProfile.Individual;
import WeekFive.InsuranceManagementSystem.Exception.InvalidAuthenticationException;
import WeekFive.InsuranceManagementSystem.User;

import java.util.TreeSet;

public class AccountManager implements Comparable<Account>{
    private TreeSet<Account> accountSet;

    public AccountManager(){
        accountSet = new TreeSet<>();
    }

    public void addAccount(){
        Address address = new HomeAddress("4002 st","London","Oxford","1160");
        User user1 = new User("Jennifer ", "Lawrance" , "jennifer@gmail.com", "jennifer0102", "Model", 34);
        Account account = new Individual(user1);

        Address address1 = new HomeAddress("45 Roxfield st", "Galler", "Rox", "4422");
        User user2 = new User("Ryan", "Gosling", "ryanGhost01@gmail.com", "ryangosling11", "Doctor", 44);
        Account account1 = new Enterprise(user2);
        accountSet.add(account);
        accountSet.add(account1);
    }
    public void removeAccount(Account account){
        accountSet.remove(account);
    }

    public Account login(String email, String password) throws InvalidAuthenticationException{
        for (Account account : accountSet){
            try {
                account.login(email, password);
                return account;
            }catch (InvalidAuthenticationException e){
                // Invalid email or password, continue searching
            }
        }
        return null;
    }
    @Override
    public int compareTo(Account other){
        // Compare logic for sorting
        // Impelement based on your requirements
        return 0;
        }

}
