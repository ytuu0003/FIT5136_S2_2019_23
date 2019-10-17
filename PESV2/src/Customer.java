public class Customer extends User {
    private String customerType;

    public Customer(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone, String newType){
        super(newUserId, newPwd, newFirstName, newLastName, newAddress, newPhone);
        customerType = newType;
    }

    public String getCustomerType() {
        return customerType;
    }

    @Override
    public String getUserId() {
        return super.getUserId();
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(super.toStringItem());
        dm.append(",");
        dm.append(customerType);
        return dm.toString();
    }

}
