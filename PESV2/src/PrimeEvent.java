import java.util.ArrayList;

public class PrimeEvent {
    private Display boundary;
    private DataHandler db = new DataHandler();
    private Admin admin = null;
    private Customer customer = null;
    private Owner owner = null;
    private ArrayList<Quotation> listOfQuotations = null;
    private ArrayList<Booking> listOfBookings = null;

    private void setDisplay(){
        boundary = new Display();
    }
    public boolean login(String userType, String userId, String pwd){
        setDisplay();
        db.initialList();
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
//            if (userId.equals("admin") && pwd.equals("123456")){
//                admin = new Admin("admin","123456");
//            }
//            else
             result = checkAdminValidation(userId, pwd);
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
//    public boolean checkCustomersValidation(String id, String pwd, ArrayList<Customer> customers){
//        boolean result = false;
//        for (Customer e : customers) {
//            if (e.getUserId().equals(id)) {
//                if (e.getPassword().equals(pwd)){
//                    result = true;
//                    customer = e;
//                }
//            }
//        }
//        return result;
//    }

//    public boolean checkOwnerValidation(String id, String pwd, ArrayList<Owner> owners){
//        boolean result = false;
//
//        for (Owner e : owners) {
//            if (e.getUserId().equals(id)) {
//                if (e.getPassword().equals(pwd)){
//                    result = true;
//                    owner = e;
//                }
//            }
//        }
//        return result;
//    }

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

    public String searchHalls(String input,String filter){
        ArrayList<Hall> halls = db.getListOfHalls();
        String found = "";
        if (filter.equals("name")){
            for (Hall h : halls){
                if (h.getName().contains(input)) {
                    found += h.toString();
                    found += "\n";
                }
            }
        }
        else if (filter.equals("address")){
            for (Hall h : halls){
                if (h.getAddress().contains(input)) {
                    found += h.toString();
                    found += "\n";
                }
            }
        }
        else if (filter.equals("capacity")){
            int inputInteger = Integer.parseInt(input);
            for (Hall h : halls){
                if (h.getCapacity() >= inputInteger) {
                    found += h.toString();
                    found += "\n";
                }
            }
        }
        else if (filter.equals("caterService")){
            for (Hall h : halls){
                if (h.isCaterService()) {
                    found += h.toString();
                    found += "\n";
                }
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
            if (listOfQuotations.get(i).getOwnerId().equals(owner.getUserId()) && listOfQuotations.get(i).getState() == 0) {
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
                try {
                    choice = Integer.parseInt(boundary.askForInput("Please input your choice: "));
                }catch(NumberFormatException e) {
                    boundary.displayMessage("Input is not an int value");
                }
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
                try {
                    provideIndex = Integer.parseInt(boundary.askForInput("Providing a quotation please input 1.\nRejecting please input -1: "));
                }catch(NumberFormatException e) {
                    boundary.displayMessage("Input must be -1 or 1");
                }
            }
            listOfQuotations.get(indexSlot.get(choice - 1)).setState(provideIndex);
            if (provideIndex == 1)
                boundary.displayMessage("You have provided the quotation");
            else if (provideIndex == -1)
                boundary.displayMessage("You have rejected the quotation");
        }
    }
    public boolean changeBooking(){
        boolean operateState = true;
        ArrayList<Booking> bookings = db.getListOfBookings();
        ArrayList<Integer> filteredBookingList = new ArrayList<Integer>();

        //filter the bookings which belong to this customer.
        for (int i = 0; i < bookings.size(); i++){
            if (customer.getUserId().equals(bookings.get(i).getCustId())){
                filteredBookingList.add(i);
            }
        }

        // there is zero bookings for this customer, return false.
        if (filteredBookingList.size() == 0)
            return false;

        String displayMessege = "";
        for (int i = 0; i < filteredBookingList.size(); i++){
            int no = i + 1;
            int index = filteredBookingList.get(i);
            displayMessege = displayMessege + "No." + no + " " + bookings.get(index).toString() + "\n";
        }
        String whetherToChange = "";
        boundary.displayMessage("Do you need to change the date or time of any booking?[Y/N]:");
        whetherToChange = boundary.notNullInput();
        if (whetherToChange.charAt(0) != 'Y' && whetherToChange.charAt(0) != 'y'){
            boundary.displayMessage("Backing to customer menu...");
            return false;
        }
        else {
            boundary.displayMessage(displayMessege);
            String indexString = "";
            int inputIndex = 0;
            boolean flag = true;
            while (flag) {
                indexString = boundary.askForInput("Please enter the number of the booking to change: ");
                try {
                    inputIndex = Integer.parseInt(indexString);
                } catch (NumberFormatException e) {
                }
                if (inputIndex > 0 && inputIndex <= filteredBookingList.size())
                    flag = false;
                else
                    boundary.displayMessage("Invalid input! Please try again.");
            }
            String dnt = boundary.askForInput("Please enter a new date and time (e.g. 01122019 15:00)");
            String confirm = boundary.askForInput("Are you sure? reply: yes/no");
            boolean cf = false;
            if (confirm.equals("yes"))
                cf = true;
            else
                return false;
            if (cf) {
                int j = inputIndex - 1;
                int id = filteredBookingList.get(j);
                bookings.get(id).setDateAndTime(dnt);
                boundary.displayMessage("Successful!!");
            } else
                boundary.displayMessage("Sorry, there are some problems");
            return operateState;
        }
    }
//    public void bookAHall(){
//        //readQuotationlist();
//        listOfQuotations = db.listOfQuotations;
//        ArrayList<Integer> indexSlot = new ArrayList<>();
//        String quotationInfo = "";
//        String message = "";
//        System.out.println(listOfQuotations.size());
//        for (int i = 0; i < listOfQuotations.size(); i++) {
//            System.out.println(listOfQuotations.get(i).getCustomerId());
//            System.out.println(customer.getUserId());
//            System.out.println(listOfQuotations.get(i).getState());
//            if (listOfQuotations.get(i).getCustomerId().equals(customer.getUserId()) && listOfQuotations.get(i).getState() == 1) {
//                indexSlot.add(i);
//            }
//        }
//
//        for (int i = 0; i < indexSlot.size(); i++){
//            quotationInfo = (i + 1) + ". " + listOfQuotations.get(indexSlot.get(i)).displayQuotationInfo() + "\n";
//            boundary.displayMessage(quotationInfo);
//        }
//
//        int choice = 0;
//        if (indexSlot.size()==0){
//            boundary.displayMessage("There is no quotation replied from owner...");
//        }
//        else {
//            while (choice < 1 || choice > indexSlot.size()) {
//                choice = Integer.parseInt(boundary.askForInput("Please input your choice: "));
//            }
//            message += "================Quotation Info==================\n";
//            message += quotationInfo;
//            message += "Deposit: ";
//            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2) + "\n";
//            message += "You are paying this quotation...\n";
//            message += "================================================\n";
//            boundary.displayMessage(message);
//
//            String enterPayment = "";
//            enterPayment = boundary.askForInput("Please input 'Y' to make a payment. Or cancel by inputting any other keys.");
//            if (enterPayment.charAt(0) == 'Y' || enterPayment.charAt(0) == 'y') {
//                message = "You have booked the hall successfully.";
//                boundary.displayMessage(message);
//                String receipt = "";
//                receipt += "=================Receipt=================\n";
//                receipt += quotationInfo;
//                receipt += "Price: ";
//                receipt = receipt + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(0) + "\n";
//                receipt += "Deposit: ";
//                receipt = receipt + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2) + "\n";
//                receipt += "=========================================\n";
//                boundary.displayMessage(receipt);
//                String[] quotationFields = listOfQuotations.get(indexSlot.get(choice - 1)).splitQuotationInfo();
//                //needs to new a Booking class.
//                //listOfBookings.add();
//            } else {
//                boundary.customerMenu();
//            }
//        }
//    }
public void bookAHall(){
    //readQuotationlist();
    listOfQuotations = db.getListOfQuotations();
    ArrayList<Integer> indexSlot = new ArrayList<>();
    String quotationInfo = "";
    String message = "";
    for (int i = 0; i < listOfQuotations.size(); i++) {
        if (listOfQuotations.get(i).getCustomerId().equals(customer.getUserId()) && listOfQuotations.get(i).getState() == 1) {
            indexSlot.add(i);
        }
    }

    for (int i = 0; i < indexSlot.size(); i++){
        quotationInfo = (i + 1) + ". " + listOfQuotations.get(indexSlot.get(i)).displayQuotationInfo() + "\n";
        boundary.displayMessage(quotationInfo);
    }

    if (indexSlot.size() == 0) {
        boundary.displayMessage("There is no new quotation...");
        boundary.enterToContinue();
    }
    else{
        int choice = 0;
        while (choice < 1 || choice > indexSlot.size()) {
            try {
                choice = Integer.parseInt(boundary.askForInput("Please input your choice: "));
            }catch(NumberFormatException e) {
                boundary.displayMessage("Input is not an int value");
            }
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
        if (enterPayment.charAt(0) == 'Y' || enterPayment.charAt(0) == 'y'){
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
            Booking newBooking = new Booking();
            //The txt file needs to write like that. (Attendance, Cater, DateAndTime, Deposit, Purpose, TotalPrice)
            String[] quotationFields = new String[6];
            quotationFields = listOfQuotations.get(indexSlot.get(choice - 1)).splitQuotationInfo();

            newBooking.setBookingID(generateBookingId());
            newBooking.setCustomerId(customer.getUserId());
            newBooking.setHallId(listOfQuotations.get(indexSlot.get(choice - 1)).getHallId());
            newBooking.setAttendance(Integer.parseInt(quotationFields[0]));
            newBooking.setCater(Boolean.parseBoolean(quotationFields[1]));
            newBooking.setDateAndTime(quotationFields[2]);
            newBooking.setDeposit(listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2));
            newBooking.setPurpose(quotationFields[4]);
            newBooking.setReview("");
            newBooking.setTotalPrice(listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(0));
            db.addBooking(newBooking);
        }
        else{
            boundary.displayMessage("Booking canceled.\nBacking to home paging...");
            boundary.customerMenu();
        }
    }

}

public String generateBookingId(){
    int bookingId = 0;
    String strBookingId = "";
    int size = 0;
    size = db.getListOfBookings().size();
    if (size < 1)
        size = 101;
    bookingId = Integer.parseInt(db.getListOfBookings().get(size - 1).getBookingID()) + 1;
    strBookingId = bookingId + "";
    return strBookingId;

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
    }*/
//    public void writeCustomers(){
//        ArrayList<Customer> customers = new ArrayList<>();
//        customers = readCustomers();
//        customers.add(customer);
//    }
//    public void writeOwner(){
//        ArrayList<Owner> owners = new ArrayList<>();
//        owners = readOwners();
//        owners.add(owner);
//    }
    public boolean logout(){
        boolean state = false;
        state = db.updateList();
        if (state){
            db.cleanList();
        }
        return state;
    }
}
