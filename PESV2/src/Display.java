import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;

/**
 * This Display Class represents a boundary object of the system.
 * It used to generate a boundary object to receive and display message.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Display {
    private PrimeEvent controller;
    private String userType = null;

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        Display boundary = new Display();
        boundary.setController();
        boolean flag = true;
        while(flag){
            boundary.displayLoginMenu();
            if (boundary.userType.equals("customer"))
                boundary.customerMenu();
            else if (boundary.userType.equals("owner"))
                boundary.ownerMenu();
        }
    }

    private void setController(){
        controller = new PrimeEvent();
    }

    /**
     * Receives the enter input to control the system operating process
     * */
    public void enterToContinue(){
        System.out.println("Please enter to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    /**
     * Checks whether the input is null or not
     *
     * @return return the input as String object if it is not null otherwise ask for input repeatedly
     * */
    public String notNullInput(){
        String input = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            input = sc.nextLine();
            if (input.isEmpty())
                System.out.println("Null value input! please try again:");
            else
                return input;
        }
    }

    private void displayLoginMenu(){
        boolean flag = true;
        //Scanner sc = new Scanner(System.in);
        char choice = 'D';
        String email = "";
        String pw = "";

        while(flag) {
            loginMenu();
            choice = notNullInput().charAt(0);
            switch (choice) {
                case 'A':
                case 'a':
                    System.out.println("Please enter customer user ID (Your Email address):");
                    email = notNullInput();
                    System.out.println("Please enter user password (Input 0000 if you forget your password):");
                    pw = notNullInput();
                    if (pw.equals("0000"))
                        pw = forgetPassword();
                    else
                        if(controller.login("customer", email, pw)){
                            System.out.println("Welcome, " + email);
                            flag = false;
                            userType = "customer";
                        }
                        else
                            System.out.println("User ID or password error, please try again.\n");
                    break;
                case 'B':
                case 'b':
                    System.out.println("Please enter property owner user ID (Your Email address):");
                    email = notNullInput();
                    System.out.println("Please enter user password (Input 0000 if you forget your password):");
                    pw = notNullInput();
                    if (pw.equals("0000"))
                        pw = forgetPassword();
                    else
                        if(controller.login("owner", email, pw)){
                            System.out.println("Welcome, " + email);
                            flag = false;
                            userType = "owner";
                        }
                        else
                            System.out.println("User ID or password error, please try again.\n");
                    break;
                case 'C':
                case 'c':
                    System.out.println("Please enter admin ID:");
                    email = notNullInput();
                    System.out.println("Please enter user password:");
                    pw = notNullInput();
                    if(controller.login("admin", email, pw)){
                        System.out.println("Welcome, " + email);
                        flag = false;
                        userType = "admin";
                    }
                    else
                        System.out.println("User ID or password error, please try again.\n");
                    break;
                case 'D':
                case 'd':
                    System.out.println("Please enter the account type you want to register");
                    System.out.println("('C' for customer or 'O' for property owner):");
                    String type = notNullInput();
                    String[] newUserInfo;
                    if (type.charAt(0) == 'C' || type.charAt(0) == 'c') {
                        newUserInfo = askRegisterInfo("customer");
                        controller.register("customer", newUserInfo);
                        userType = "customer";
                        flag = false;
                    }
                    else if (type.charAt(0) == 'O' || type.charAt(0) == 'o') {
                        newUserInfo = askRegisterInfo("owner");
                        controller.register("owner", newUserInfo);
                        userType = "owner";
                        flag = false;
                    }
                    else {
                        System.out.println("Invalid input!");
                        break;
                    }
                    break;
                case 'E':
                case 'e':
                    System.out.println("Exit...Goodbye!");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input. Please select again:");
                    break;
            }
        }
    }

    /**
     * Asks for particular information according to the message
     *
     * @param message the message about what information system asks for.
     * @return A String object that contains the information system asks for.
     * */
    public String askForInput(String message){
        String returnMessage = "";
        System.out.println(message);
        returnMessage = notNullInput();
        return returnMessage;
    }

    /**
     * Asks for integer information in domain according to the message
     *
     * @param upper the maximum of required domain.
     * @param limit the minimum of required domain.
     * @param message the message about what information system asks for.
     * @return A String object that contains the information system asks for.
     * */
    public int askForIntInput(int upper, int limit, String message){
        System.out.println(message);
        int input = 0;
        boolean validInput = false;
        while (!validInput){
            try{
                input = Integer.parseInt(notNullInput());
                if (input > upper || input < limit) {
                    throw new InvalidAlgorithmParameterException("");
                }
                validInput = true;
            }catch (NumberFormatException e)
            {
                displayMessage("Input must be integer...Please input again.");
            }catch (InvalidAlgorithmParameterException ce)
            {
                if (upper == limit)
                    displayMessage("There is only one option...Please input again.");
                else
                    displayMessage("The input is not between " + limit + " and " + upper + "...Please input again.");
            }
        }

        return input;
    }

    /**
     * Asks for register information.
     *
     * @param userType the user type that user want to register.
     * @return A String object that contains the register information.
     * */
    public String[] askRegisterInfo(String userType){
        Scanner sc = new Scanner(System.in);
        String[] registerInfo = new String[7];
        System.out.println("Please enter user ID (Your Email address):*");
        registerInfo[0] = notNullInput();
        registerInfo[1] = inputPassword();
        System.out.println("Please enter your first name:*");
        registerInfo[2] = notNullInput();
        System.out.println("Please enter your last name:*");
        registerInfo[3] = notNullInput();
        System.out.println("Please enter your address:");
        registerInfo[4] = "";
        registerInfo[4] = sc.nextLine();
        System.out.println("Please enter your phone number:*");
        registerInfo[5] = notNullInput();
        if (userType.equals("customer")) {
            System.out.println("Please enter your Customer type:");
            registerInfo[6] = sc.nextLine();
            if(registerInfo[6]=="")
                registerInfo[6] = "null";
        }
        return registerInfo;
    }

    private String inputPassword() {
        //Scanner sc = new Scanner(System.in);
        String pw = "";
        String pw1 = "";
        String pw2 = "";
        while(true) {
            System.out.println("Please enter user password:");
            pw1 = notNullInput();
            System.out.println("Confirm password:");
            pw2 = notNullInput();
            if (pw1.equals(pw2))
            {
                pw = pw1;
                break;
            }
            else
                System.out.println("The passwords entered are inconsistent. Please try again:");
        }
        return pw;
    }

    /**
     * Asks for reseting password.
     *
     * @return A String object that contains the new password information.
     * */
    public String forgetPassword(){
        System.out.println("Reset new password:");
        String newPwd = "";
        newPwd = inputPassword();
        return newPwd;
    }

    private void ownerMenu(){
        System.out.println("Hello, property owner!");
        boolean flag = true;
        char choice = '0';
        while(flag) {
            System.out.println("======================Owner Menu====================");
            System.out.println("1. View my properties");
            System.out.println("2. Create a hall");
            System.out.println("3. View hall discounts");
            System.out.println("4. Add a discount");
            System.out.println("5. View requests");
            System.out.println("6. View payment");
            System.out.println("7. Update account information");
            System.out.println("8. Reset password");
            System.out.println("9. Logout");
            System.out.println("====================================================");

            choice = notNullInput().charAt(0);
            switch (choice) {
                case '1':
                    viewMyHall();
                    break;
                case '2':
                    createHall();
                    break;
                case '3':
                    viewMyDiscounts();
                    break;
                case '4':
                    addDiscount();
                    break;
                case '5':
                    controller.provideAQuotaton();
                    break;
                case '6':
                    viewPayments();
                    break;
                case '7':
                    updateAccount();
                case '8':
                    inputPassword();
                    break;
                case '9':
                    flag = false;
                    logout();
                    break;
            }
        }
    }

    /**
     * Displays the hall list that belongs to the owner.
     * */
    public void viewMyHall() {
        incompleteFunction();
    }

    private void incompleteFunction(){
        System.out.println("We are working on this function...Come back soon:)");
    }

    /**
     * Receives the new hall information.
     * */
    public void createHall() {
        incompleteFunction();
    }

    private void customerMenu(){
        System.out.println("Hello, customer!");
        boolean flag = true;
        char choice = '0';
        while(flag) {
            System.out.println("====================Customer Menu===================");
            System.out.println("1. View all halls");
            System.out.println("2. Search for a hall");
            System.out.println("3. View bookings");
            System.out.println("4. Book a hall");
            System.out.println("5. Update account information");
            System.out.println("6. Reset password");
            System.out.println("7. Logout");
            System.out.println("====================================================");

            choice = notNullInput().charAt(0);
            switch (choice) {
                case '1':
                    viewAllHalls();
                    break;
                case '2':
                    searchHalls();
                    break;
                case '3':
                    viewBookings();
                    break;
                case '4':
                    controller.bookAHall();
                    break;
                case '5':
                    updateAccount();
                    break;
                case '6':
                    inputPassword();
                    break;
                case '7':
                    flag = false;
                    logout();
                    break;
            }
        }
    }

    /**
     * Displays the booking list for this customer and provide change booking function.
     * */
    public void viewBookings(){
        controller.changeBooking();
        //incompleteFunction();
    }

    /**
     * Displays the list of all the hall information
     * */
    public void viewAllHalls()
    {
        System.out.println(controller.searchHalls("","name"));
        sendQuotation();
    }

    /**
     * Displays the log out information and clear data
     * */
    public void logout(){
        controller.logout();
        System.out.println("Goodbye.");
    }

    /**
     * Displays the discount list that belongs to the owner.
     * */
    public void viewMyDiscounts() {
        incompleteFunction();
    }

    /**
     * Adds a discount into the discount list that belongs to the owner.
     * */
    public void addDiscount(){
        incompleteFunction();
    }

    /**
     * Displays the payment information.
     * */
    public void viewPayments(){
        incompleteFunction();
    }

    /**
     * Updates the account information.
     * */
    public void updateAccount(){
        incompleteFunction();
    }

    private boolean searchHallByName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input hall name:");
        String hallName = notNullInput();
        String hallsFound = "";
        hallsFound = controller.searchHalls(hallName,"name");
        if (hallsFound.isEmpty())
            displayMessage("Hall with name " + hallName + " cannot found!");
        else {
            displayMessage(hallsFound);
            sendQuotation();
        }
        return true;
    }
    private boolean searchHallByAddr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input an address keyword:");
        String hallAddress = sc.nextLine();
        String hallsFound = "";
        hallsFound = controller.searchHalls(hallAddress,"address");
        if (hallsFound.isEmpty())
            displayMessage("Hall in " + hallAddress + " cannot found!");
        else {
            displayMessage(hallsFound);
            sendQuotation();
        }
        return true;
    }
    private boolean searchHallByCatar(){
        String hallsFound = "";
        hallsFound = controller.searchHalls("","caterService");
        if (hallsFound.isEmpty())
            displayMessage("Hall provides cater service cannot found!");
        else {
            displayMessage(hallsFound);
            sendQuotation();
        }
        return true;
    }
    private boolean searchHallByCapacity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input capacity you need:");
        int capacity = 0;
        String input = sc.nextLine();
        String hallsFound = "";
        try{
            capacity = Integer.parseInt(input);
        }
        catch(Exception e){
            System.out.println("Capacity should be a number! Please try again");
            return false;
        }
        hallsFound = controller.searchHalls(input,"capacity");
        if (hallsFound.isEmpty())
            displayMessage("Hall capacity larger than " + capacity + " cannot found!");
        else {
            displayMessage(hallsFound);
            sendQuotation();
        }
        return true;
    }

    /**
     * Receive the choice for searching methods.
     * */
    public void searchHalls(){
        boolean flag = false;
        int choice = 6;
        while (choice != 5 && !flag) {
            //Scanner sc = new Scanner(System.in);
            System.out.println("===================Search Hall Menu==================");
            System.out.println("Please choose a filter:");
            System.out.println("1. Hall name. \n2. Hall address. \n3. Cater Service needed. \n4. Capacity of event. \n5. Return to home page.");
            String input = notNullInput();
            if (input.length() == 0) {
                choice = 6;
            }
            switch (input.charAt(0)) {
                case '1':
                    flag = searchHallByName();
                    break;
                case '2':
                    flag = searchHallByAddr();
                    break;
                case '3':
                    flag = searchHallByCatar();
                    break;
                case '4':
                    flag = searchHallByCapacity();
                    break;
                case '5':
                    System.out.println("Going back to home page...");
                    flag = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Asks for dealing with the incomplete quotation.
     * */
    public void sendQuotation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to send a quotation?");
        String input = "";
        input = sc.nextLine();
        if (input.length() == 0)
            System.out.println("Sending quotation canceled. Back to home page...");
        else if (input.charAt(0) == 'y' || input.charAt(0) == 'Y')
            System.out.println("Sending quotation successfully!");
        else
            System.out.println("Sending quotation canceled. Back to home page...");
    }

    /**
     * Display the message
     * */
    public void displayMessage(String message){
        System.out.println(message);
    }

    private void loginMenu(){
        System.out.println("Welcome to Prime Event System!");
        System.out.println("Please login first.(Select your user identity type)");
        System.out.println("A. Customer");
        System.out.println("B. Property Owner");
        System.out.println("C. Administrator");
        System.out.println("D. Don't have an account yet.(Register now!)");
        System.out.println("E. Exit system");
    }
}
