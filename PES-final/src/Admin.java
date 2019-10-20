/**
 * This Admin Class represents an admin object in the system.
 * It used to generate an admin object.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Admin {
    private String password;
    private String userId;

    /**
     * Creates an administrator with a new  id and new password.
     *
     * @param newId The new id of this administrator.
     * @param  newPwd The new password of this administrator.
     * */
    public Admin(String newId, String newPwd){
        userId = newId;
        password = newPwd;
    }

    /**
     * Gets the password of an administrator
     *
     * @return  A string object that contains the password information of an administrator
     *
     * */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of an administrator.
     *
     * @param password the new password information
     * */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the id of an administrator
     *
     * @return A String object which contains the id information.
     * */
    public String getUserId() {
        return userId;
    }
}
