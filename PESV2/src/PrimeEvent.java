import java.util.ArrayList;

public class PrimeEvent {
    private Display boundary;
    private DataHandler db = new DataHandler();
    private Admin admin = null;
    private Customer customer = null;
    private Owner owner = null;
    private ArrayList<Quotation> listOfQuotations = null;

    private void setDisplay(){
        boundary = new Display();
    }
    public boolean login(String userType, String userId, String pwd){
        setDisplay();
        db.testData();
        boolean result = true;
         if(userType.equals("customer")){
             customer = db.validateCustomer(userId,pwd);
             if (customer == null)
                 result = false;
         }
        else if(userType.equals("owner")){
            owner = db.validateOwner(userId,pwd);
            if (owner == null)
                result = false;
        }
        else if (userType.equals("admin")){
            if (userId.equals("admin") && pwd.equals("123456")){
                admin = new Admin("admin","123456");
            }
            else
                result = false;
         }
         return result;
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

    public boolean register(String userType, String[] details){
        boolean result = false;
        if (userType.equals("customer")){
            customer = new Customer(details[0],details[1],details[2],details[3],details[4],details[5],details[6]);
            db.addCustomer(customer);
            result = true;
        }
        else if (userType.equals("owner")){
            owner = new Owner(details[0],details[1],details[2],details[3],details[4],details[5]);
            db.addOwner(owner);
            result = true;
        }
        return result;
    }

    public String searchHalls(String hallName){
        ArrayList<Hall> halls = db.getListOfHalls();
        String found = "";
        for (Hall h : halls){
            if (h.getName().contains(hallName)) {
                found += h.toString();
            }
        }
        return found;
    }
    public void provideAQuotaton(){
        //readQuotationlist();
        listOfQuotations = db.listOfQuotations;
        ArrayList<Integer> indexSlot = new ArrayList<>();
        String quotationInfo = "";
        String message = "";
        for (int i = 0; i < listOfQuotations.size(); i++) {
            if (listOfQuotations.get(i).getOwnerId() == owner.getUserId() && listOfQuotations.get(i).getState() == 0) {
                indexSlot.add(i);
            }
        }
        if (indexSlot.size() == 0)
            boundary.displayMessage("There is no new quotation...");
        else {
            for (int i = 0; i < indexSlot.size(); i++){
                quotationInfo = (i+1) + ". " + listOfQuotations.get(indexSlot.get(i)).displayQuotationInfo() + "\n";
                boundary.displayMessage(quotationInfo);
            }
            int choice = 0;
            while (choice < 1 || choice > indexSlot.size()) {
                choice = Integer.parseInt(boundary.askForInput("Please input your choice: ")) ;
            }
            message += "================Quotation Info==================\n";
            message += quotationInfo;
            message += "Price: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(0) + "\n";
            message += "Discount Percent: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(1) + "\n";
            message += "Deposit: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2) + "\n";
            message += "================================================\n";
            boundary.displayMessage(message);
            int provideIndex = 0;
            while (!(provideIndex == -1 || provideIndex == 1)) {
                provideIndex = Integer.parseInt(boundary.askForInput("Providing a quotation please input 1.\nRejecting please input -1: "));
            }
            listOfQuotations.get(indexSlot.get(choice - 1)).setState(provideIndex);
            if (provideIndex == 1)
                boundary.displayMessage("You have provided the quotation");
        }
    }
    public void bookAHall(){
        //readQuotationlist();
        listOfQuotations = db.listOfQuotations;
        ArrayList<Integer> indexSlot = new ArrayList<>();
        String quotationInfo = "";
        String message = "";
        System.out.println(listOfQuotations.size());
        for (int i = 0; i < listOfQuotations.size(); i++) {
            System.out.println(listOfQuotations.get(i).getCustomerId());
            System.out.println(customer.getUserId());
            System.out.println(listOfQuotations.get(i).getState());
            if (listOfQuotations.get(i).getCustomerId().equals(customer.getUserId()) && listOfQuotations.get(i).getState() == 1) {
                indexSlot.add(i);
            }
        }

        for (int i = 0; i < indexSlot.size(); i++){
            quotationInfo = (i + 1) + ". " + listOfQuotations.get(indexSlot.get(i)).displayQuotationInfo() + "\n";
            boundary.displayMessage(quotationInfo);
        }

        int choice = 0;
        if (indexSlot.size()==0){
            boundary.displayMessage("There is no quotation replied from owner...");
        }
        else {
            while (choice < 1 || choice > indexSlot.size()) {
                choice = Integer.parseInt(boundary.askForInput("Please input your choice: "));
            }
            message += "================Quotation Info==================\n";
            message += quotationInfo;
            message += "Deposit: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2) + "\n";
            message += "You are paying this quotation...\n";
            message += "================================================\n";
            boundary.displayMessage(message);

            String enterPayment = "";
            enterPayment = boundary.askForInput("Please input 'Y' to make a payment. Or cancel by inputting any other keys.");
            if (enterPayment.charAt(0) == 'Y' || enterPayment.charAt(0) == 'y') {
                message = "You have booked the hall successfully.";
                boundary.displayMessage(message);
                String receipt = "";
                receipt += "=================Receipt=================\n";
                receipt += quotationInfo;
                receipt += "Price: ";
                receipt = receipt + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(0) + "\n";
                receipt += "Deposit: ";
                receipt = receipt + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2) + "\n";
                receipt += "=========================================\n";
                boundary.displayMessage(receipt);
                String[] quotationFields = listOfQuotations.get(indexSlot.get(choice - 1)).splitQuotationInfo();
                //needs to new a Booking class.
                //listOfBookings.add();
            } else {
                boundary.customerMenu();
            }
        }
    }


 /*   public ArrayList<Customer> readCustomers(){
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
    public void writeCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        customers = readCustomers();
        customers.add(customer);
    }
    public void writeOwner(){
        ArrayList<Owner> owners = new ArrayList<>();
        owners = readOwners();
        owners.add(owner);
    }*/
}
