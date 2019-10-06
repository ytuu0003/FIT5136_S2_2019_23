import java.util.ArrayList;

public class PrimeEvent {
    private ArrayList<Hall> listOfHalls = new ArrayList<>();
    //ArrayList<Booking> listOfBookings = new ArrayList<>();
    //ArrayList<Quotation> listOfQuotations = new ArrayList<>();
    //ArrayList<Discount> listOfDiscounts = new ArrayList<>();
    //ArrayList<Concession> listOfConcessions = new ArrayList<>();
    private Admin admin = null;
    private Customer customer = null;
    private Owner owner = null;

    public static void main(String[] args) {
        PrimeEvent system = new PrimeEvent();
        system.login();
    }

    public void login(){
        boolean result = false;
        Display sc = new Display();
        String loginInfo = "";
        while(!result) {
            loginInfo = sc.login();
            String[] details = loginInfo.split(" ");

            if (details[0] == "1" || details[0] == "2")
                register(details);
            else if (details[0] == "A")
                result = checkCustomersValidation(details[1], details[2], readCustomers());
            else if (details[0] == "B")
                result = checkOwnerValidation(details[1], details[2], readOwners());
            else if (details[0] == "C")
                result = checkAdminValidation(details[1], details[2]);
            if (result == true)
                sc.displayMessage("Login successfully!");
            else
                sc.displayMessage("Login failure!");
        }
    }

    public boolean checkAdminValidation(String id, String pwd){
        boolean result = false;
        if (id.equals("admin") && pwd.equals("123456"))
            result = true;
        admin = new Admin("admin","123456");
        return result;
    }
    public boolean checkCustomersValidation(String id, String pwd, ArrayList<Customer> customers){
        boolean result = false;
        for (Customer e : customers) {
            if (e.getUserId().equals(id)) {
                if (e.getPassword().equals(pwd)){
                    result = true;
                    customer = e;
                }
            }
        }
        return result;
    }

    public boolean checkOwnerValidation(String id, String pwd, ArrayList<Owner> owners){
        boolean result = false;

        for (Owner e : owners) {
            if (e.getUserId().equals(id)) {
                if (e.getPassword().equals(pwd)){
                    result = true;
                    owner = e;
                }
            }
        }
        return result;
    }

    public void register(String[] details){

    }
    public ArrayList<Customer> readCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        Customer cus1 = new Customer("101","123","Lucy","Huang","Caulfield","10021","");
        Customer cus2 = new Customer("102","111","Hazel","Li","CBD","10022","");
        customers.add(cus1);
        customers.add(cus2);
        return customers;
    }

    public ArrayList<Owner> readOwners(){
        ArrayList<Owner> owners = new ArrayList<>();
        Owner owner1 = new Owner("201","123","Alva","Ni","aaa","10023");
        Owner owner2 = new Owner("202","111","Kenny","Li","CBD","10024");
        owners.add(owner1);
        owners.add(owner2);
        return owners;
    }
}
