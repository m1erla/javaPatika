package WeekFive.InsuranceManagementSystem;

import WeekFive.InsuranceManagementSystem.AddressController.Address;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private User user;
        private String name;
        private String lastName;
        private String email;
        private String password;
        private String profession;
        private int age;
        private ArrayList<Address> addressList;
        private Date lastLoginDate;

        // Constructor

        public User(){

        }
        public User(String name, String lastName, String email, String password, String profession, int age) {
            this.name = name;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.profession = profession;
            this.age = age;
        }

        // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    // Other methods as per your requirements

    public static void addAddress(User user, Address address) {
        user.getAddressList().add(address);
    }

    // Remove an address from the user's address list
    public static void removeAddress(User user, Address address) {
        user.getAddressList().remove(address);
    }
     public User getUser(){
            return  user;
     }
    }


