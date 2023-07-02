package WeekFive.InsuranceManagementSystem.AddressController;

public class BusinessAddress implements Address{

    @Override
    public void setAddress(String address) {

    }

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String companyName;

    // Constructor
    public BusinessAddress(String street, String city, String state, String zipCode, String companyName) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.companyName = companyName;
    }

    // Implementing the getAddress() method from the Address interface
    @Override
    public String getAddress() {
        return street + ", " + city + ", " + state + " " + zipCode + " (" + companyName + ")";
    }

    // Other methods specific to BusinessAddress class


}
