public class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;

    public User(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone){
        userId = newUserId;
        password = newPwd;
        firstName = newFirstName;
        lastName = newLastName;
        address = newAddress;
        phoneNo = newPhone;
    }

    public String getUserId(){
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
