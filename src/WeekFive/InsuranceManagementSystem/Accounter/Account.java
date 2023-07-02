package WeekFive.InsuranceManagementSystem.Accounter;

import WeekFive.InsuranceManagementSystem.AddressController.Address;
import WeekFive.InsuranceManagementSystem.AddressController.AddressManager;
import WeekFive.InsuranceManagementSystem.Exception.InvalidAuthenticationException;
import WeekFive.InsuranceManagementSystem.Insurances.Insurance;
import WeekFive.InsuranceManagementSystem.User;

import java.util.*;

public abstract class Account implements Comparable<Account>{
    private Insurance insurance;
    private AuthenticationStatus loginStatus;
    private User user;
    private List<Insurance> insuranceList;

    public enum AuthenticationStatus {
        SUCCESS, FAIL
    }

    public Account(User user) {
        this.user = user;
        this.loginStatus = AuthenticationStatus.FAIL;
        this.insuranceList = new ArrayList<>();
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            loginStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Invalid email or password");
        }
    }

    public void addAddress(Address address) {
        AddressManager.addAddress(user, address);
    }

    public void removeAddress(Address address) {
        user.getAddressList().remove(address);
    }

    public List<Insurance> getInsuranceList() {
        List<String> list = new ArrayList<>();
        list.add("Allianz Health Insurance");
        list.add("Fiat Car Insurance");
        list.add("Residence Insurance");
        list.add("Travel Insurance");
        for (String str : list) {
            System.out.println(str);
        }
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }
    public Insurance getInsurance(){
        return insurance;
    }
    public void setInsurance(Insurance insurance){
       insurance = insurance;
    }
    public AuthenticationStatus getLoginStatus() {
        return loginStatus;
    }


    public final void showUserInfo() {
        User user = new User();
        System.out.println("User Information:");
        System.out.println("Name: " + user.getName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Profession: " + user.getProfession());
        System.out.println("Age: " + user.getAge());
        System.out.println("Last Login Date: " + user.getLastLoginDate());
        System.out.println("Addresses:");
        for (Address address : user.getAddressList()) {
            System.out.println(address.getAddress());
        }
    }
    // Add insurance to the list
    public void addInsurance(Insurance insurance){
        insuranceList.add(insurance);
    }
    // Remove insurance from the list
    public void removeInsurance(Insurance insurance){
        insuranceList.remove(insurance);
    }
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    public void insuranceList(){
        if (insuranceList.size() == 0){
            System.out.println("You do not have any insurance policy");
        }
    }
}






