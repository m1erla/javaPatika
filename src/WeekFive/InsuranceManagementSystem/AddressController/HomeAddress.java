package WeekFive.InsuranceManagementSystem.AddressController;

public class HomeAddress implements Address{

        private String street;
        private String city;
        private String state;
        private String zipCode;

        // Constructor
        public HomeAddress(String street, String city, String state, String zipCode) {
            this.street = street;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }

    @Override
    public void setAddress(String address) {

    }

    // Implementing the getAddress() method from the Address interface
        @Override
        public String getAddress() {
            return street + ", " + city + ", " + state + " " + zipCode;
        }

        // Other methods specific to HomeAddress class
}

