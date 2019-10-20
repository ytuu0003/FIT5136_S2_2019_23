/**
 * This Owner Class represents a owner object in the system.
 * It used to generate a owner object.
 *
 * @author XuShan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Owner extends User {

    /**
     * Creates an owner with a new user id, new password, new first and last name, new address and new phone number.
     *
     * @param newUserId The new id of this new owner.
     * @param  newPwd The new password of this owner.
     * @param  newFirstName The first name of this owner.
     * @param  newLastName The last name of this owner.
     * @param  newAddress The address of this owner.
     * @param  newPhone The phone number of this owner.
     * */
    public Owner(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone){
        super(newUserId, newPwd, newFirstName, newLastName, newAddress, newPhone);
    }

    /**
     * Returns a string information of a particular owner
     *
     * @return  A String object that contains the owner details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(super.toStringItem());
        return dm.toString();
    }
}