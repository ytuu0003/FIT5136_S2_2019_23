/**
 * This User Class represents a user object in the system.
 * It used to generate a user object.
 *
 * @author XuShan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;

    /**
     * Creates a user with a new user id, new password, new first and last name, new address and new phone number.
     *
     * @param newUserId The new id of this new user.
     * @param  newPwd The new password of this user.
     * @param  newFirstName The first name of this user.
     * @param  newLastName The last name of this user.
     * @param  newAddress The address of this user.
     * @param  newPhone The phone number of this user.
     * */
    public User(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone){
        userId = newUserId;
        password = newPwd;
        firstName = newFirstName;
        lastName = newLastName;
        address = newAddress;
        phoneNo = newPhone;
    }

    /**
     * Gets the id of a user
     *
     * @return A String object which contains the id information.
     * */
    public String getUserId(){
        return userId;
    }

    /**
     * Gets the password of a user
     *
     * @return  A string object that contains the password information of a user
     *
     * */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the first name of a user
     *
     * @return The String object that contains the first name of the user
     * */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of a user
     *
     * @return The String object that contains the last name of the user
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the address of a user
     *
     * @return The String object that contains the address of the user
     * */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the phone number of a user
     *
     * @return The String object that contains the phone number of the user
     * */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the password of a particular user.
     *
     * @param password the new password information
     * */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the first name of a particular user.
     *
     * @param firstName the new first name information
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of a particular user.
     *
     * @param lastName the new last name information
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the address of a particular user.
     *
     * @param address the new address information
     * */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the phone number of a particular user.
     *
     * @param phoneNo the new phone number information
     * */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Returns a string information of a particular user
     *
     * @return  A String object that contains the user details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(userId);
        dm.append(",");
        dm.append(password);
        dm.append(",");
        dm.append(firstName);
        dm.append(",");
        dm.append(lastName);
        dm.append(",");
        dm.append(address);
        dm.append(",");
        dm.append(phoneNo);
        return dm.toString();
    }
}
