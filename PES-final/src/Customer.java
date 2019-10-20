/**
 * This Customer Class represents a customer object in the system.
 * It used to generate a customer object.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Customer extends User {
    private String customerType;

    /**
     * Creates a customer with a new user id, new password, new first and last name, new address and new phone number.
     *
     * @param  newUserId The new id of this new customer.
     * @param  newPwd The new password of this customer.
     * @param  newFirstName The first name of this customer.
     * @param  newLastName The last name of this customer.
     * @param  newAddress The address of this customer.
     * @param  newPhone The phone number of this customer.
     * @param  newType The type of this customer.
     * */
    public Customer(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone, String newType){
        super(newUserId, newPwd, newFirstName, newLastName, newAddress, newPhone);
        customerType = newType;
    }

    /**
     * Gets the customer type of a customer
     *
     * @return A String object which contains the customer type information.
     * */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Sets the customer type of a particular user.
     *
     * @param customerType the customer type information
     * */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * Gets the id of a customer
     *
     * @return A String object which contains the id information.
     * */
    @Override
    public String getUserId() {
        return super.getUserId();
    }

    /**
     * Returns a string information of a particular customer
     *
     * @return  A String object that contains the customer details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(super.toStringItem());
        dm.append(",");
        dm.append(customerType);
        return dm.toString();
    }

}
