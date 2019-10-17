//public class Owner extends User {
//    public Owner(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone){
//        super(newUserId, newPwd, newFirstName, newLastName, newAddress, newPhone);
//    }
//}
public class Owner extends User {
    public Owner(String newUserId, String newPwd, String newFirstName, String newLastName, String newAddress, String newPhone){
        super(newUserId, newPwd, newFirstName, newLastName, newAddress, newPhone);
    }

    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(super.toStringItem());
        return dm.toString();
    }
}