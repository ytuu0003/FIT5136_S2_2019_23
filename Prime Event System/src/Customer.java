public class Customer extends User {
    private String customerType;

    public Customer(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone, String newType){
        super(newUserId, newPwd, newFirstName, newLastName, newAddress, newPhone);
        customerType = newType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
