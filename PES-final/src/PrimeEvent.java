import java.util.ArrayList;

/**
 * This PrimeEvent Class represents a controller object in the system.
 * It used to generate a controller object to control and process messages.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class PrimeEvent {
    private Display boundary;
    private DataHandler db = new DataHandler();
    private Admin admin = null;
    private Customer customer = null;
    private Owner owner = null;
    private ArrayList<Quotation> listOfQuotations = null;
    private ArrayList<Booking> listOfBookings = null;

    /**
     * Generates a new booking object based on the quotation information and customer's choice
     * */
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
            choice = boundary.askForIntInput(indexSlot.size(), 1, "Please input your choice: ");
            message += "================Quotation Info==================\n";
            //message += quotationInfo;
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).displayQuotationInfo() + "\n";
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
                newBooking.setDateAndTime(Integer.parseInt(quotationFields[2]));
                newBooking.setDeposit(listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2));
                newBooking.setPurpose(quotationFields[4]);
                newBooking.setReview("");
                newBooking.setTotalPrice(listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(0));
                db.addBooking(newBooking);
            }
            else{
                boundary.displayMessage("Booking canceled.\nBacking to home paging...");
                listOfQuotations = null;
            }
        }
    }

    /**
     * Updates a specific booking date and time information based on the user's input.
     * @return The boolean state whether the change is sucessful or not.
     * */
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
        boundary.displayMessage(displayMessege);
        boundary.displayMessage("Do you need to change the date or time of any booking?[Y/N]:");
        whetherToChange = boundary.notNullInput();
        if (whetherToChange.charAt(0) != 'Y' && whetherToChange.charAt(0) != 'y'){
            boundary.displayMessage("Backing to customer menu...");
            return false;
        }
        else {
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

            int dnt = 0;
            boolean exist = true;
            while (exist){
                dnt = checkValidDateTime();
                exist = checkNewDateExisted(dnt/100, bookings.get(filteredBookingList.get(inputIndex-1)).getHallId());
                if (exist)
                    boundary.displayMessage("The date and time have been booked! Try another day please:");
            }

            String confirm = boundary.askForInput("Are you sure? reply: yes/no");
            boolean cf = false;
            if (confirm.isEmpty())
                cf = false;
            else if (confirm.charAt(0) =='Y' || confirm.charAt(0) =='y' )
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

    /**
     * Checks whether the log in information of an administrator is right or wrong
     * and return the validation state of the administrator information as the boolean type.
     *
     * @param id The specific id of an administrator.
     * @param pwd The password of this id.
     * @return The boolean value of log in state successful or not.
     * */
    public boolean checkAdminValidation(String id, String pwd){
        boolean result = false;
        if (id.equals("admin") && pwd.equals("123456"))
            result = true;
        admin = new Admin("admin","123456");
        return result;
    }

    private boolean checkNewDateExisted(int date, String hallId){
        boolean exist = false;
        ArrayList<Booking> bookings = db.listOfBookings;

        for (Booking booking: bookings){
            if (booking.getHallId().equals(hallId))
                if (booking.getDateAndTime()/100==date) {
                    exist = true;
                }
        }
        return exist;
    }

    private int checkValidDateTime(){
        boolean flag = false;
        int integerDnt = 0;
        int hour = 0;
        int day = 0;
        int month = 0;
        int year = 0;
        while(!flag) {
            flag = true;
            String dnt = boundary.askForInput("==========Changing date and time==========\nPlease enter new date (yyyymmdd):");
            String timeInString = boundary.askForInput("Please enter new time (24h format, input '19' if the new time begin at 7pm):");
            if (!dnt.isEmpty() && !timeInString.isEmpty()){
                try{
                    integerDnt = Integer.parseInt(dnt);
                    hour = Integer.parseInt(timeInString);
                }
                catch (Exception e)
                {
                    flag = false;
                }
                if(integerDnt/10000000==0 ||integerDnt/10000000>2) {
                    flag = false;
                }
                else {
                    if (flag) {
                        flag = false;
                        year = Integer.parseInt(dnt.substring(0,4));
                        month = Integer.parseInt(dnt.substring(4,6));
                        day = Integer.parseInt(dnt.substring(6));
                        if (day > 0 && day <= 31)
                            if (month > 0 && month <= 12)
                                if (year >= 2019 && year < 2100)
                                    if (hour >= 0 && hour < 24)
                                        flag = true;
                    }
                }
            }
            if (!flag)
                boundary.displayMessage("Invalid input, please input according to format provided!");
        }
        return integerDnt*100 + hour;
    }

    /**
     * Generates a booking id for a particular booking
     * @return The string id information for a booking.
     * */
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

    /**
     * Check the validation of a user type, user id and password
     * and return the validation state of the user information as the boolean type.
     *
     * @param userType The specific type of user who asks to log in.
     * @param userId The unique id of user who asks to log in.
     * @param pwd The password of this user id.
     * @return The boolean value of log in state successful or not.
     * */
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

    /**
     * Clears The memory data when the user asks to log out
     * @return  The boolean state whether the user log out successfully or not.
     * */
    public boolean logout(){
        boolean state = false;
        state = db.updateList();
        db.cleanList();
        return state;
    }

    /**
     * Updates the provided state of a specific quotation object based on the owner's input choice
     *
     * */
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
            choice = boundary.askForIntInput(indexSlot.size(), 1, "Please input your choice: ");
            message += "================Quotation Info==================\n";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).displayQuotationInfo() + "\n";
            message += "Price: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(0) + "\n";
            message += "Discount Percent: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(1) + "\n";
            message += "Deposit: ";
            message = message + listOfQuotations.get(indexSlot.get(choice - 1)).getPriceList(2) + "\n";
            message += "================================================\n";
            boundary.displayMessage(message);
            int provideIndex = 0;
            provideIndex = boundary.askForIntInput(1, -1,"Providing a quotation please input 1.\nRejecting please input -1: ");
            listOfQuotations.get(indexSlot.get(choice - 1)).setState(provideIndex);
            if (provideIndex == 1)
                boundary.displayMessage("You have provided the quotation.");
            else if (provideIndex == -1)
                boundary.displayMessage("You have rejected this quotation.");
        }
    }

    /**
     * Receives user's user type and information details to do registration
     * and return the state whether this user get registration successful or not.
     *
     * @param userType The specific user type of this user who asks to register.
     * @param details The information details of this user who asks to register.
     *
     * @return The registration state whether he or she get registration successful or not.
     * */
    public boolean register(String userType, String[] details){
        boolean result = false;
        db.initialList();
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
        if(!result)
            db.cleanList();
        return result;
    }

    /**
     * Filters the hall information according to the method  and the keyword received from user
     * and return the String information of relative halls.
     *
     * @param input  The keyword input by user
     * @param filter The filter type chose by the user
     * @return A String type information containing  hall information
     * */
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

    private void setDisplay(){
        boundary = new Display();
    }
}
