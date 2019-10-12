public class Admin {
    private String userId;
    private String password;

    public Admin(String newId, String newPwd){
        userId = newId;
        password = newPwd;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
