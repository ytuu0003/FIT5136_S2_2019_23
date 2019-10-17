//import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    private PrimeEvent controller;
    private String userType = null;

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

    public void enterToContinue(){
        System.out.println("Please enter to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

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

    public void displayLoginMenu(){
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
                    String userType = notNullInput();
                    String[] newUserInfo;
                    if (userType.charAt(0) == 'C' || userType.charAt(0) == 'c') {
                        newUserInfo = askRegisterInfo("customer");
                        controller.register("customer", newUserInfo);
                        flag = false;
                    }
                    else if (userType.charAt(0) == 'O' || userType.charAt(0) == 'o') {
                        newUserInfo = askRegisterInfo("owner");
                        controller.register("owner", newUserInfo);
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

    public String askForInput(String message){
        //Scanner sc = new Scanner(System.in);
        String returnMessage = "";
        System.out.println(message);
        returnMessage = notNullInput();
        return returnMessage;
    }

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
        registerInfo[4] = sc.nextLine();
        System.out.println("Please enter your phone number:");
        registerInfo[5] = sc.nextLine();
        if (userType.equals("customer")) {
            System.out.println("Please enter your Customer type:");
            registerInfo[6] = sc.nextLine();
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
    public String forgetPassword(){
        System.out.println("Reset new password:");
        String newPwd = "";
        newPwd = inputPassword();
        return newPwd;
    }

    public void ownerMenu(){
        //Scanner sc = new Scanner(System.in);
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

    public void viewMyHall() {
        incompleteFunction();
    }
//        testDisplaySampleHall1();
//        testDisplaySampleHall2();
//        System.out.println("====================================================");
//        System.out.println("Please input hall number you want to edit:");
//        System.out.println("(Input 0 or invaild symbol to return home page)");
//        Scanner sc = new Scanner(System.in);
//        char choice = '0';
//        choice = sc.nextLine().charAt(0);
//        if (choice == '1')
//            editHall('1');
//        else if (choice == '2')
//            editHall('2');
//    }

//    public void editHall(char num) {
//        System.out.println("Please select the item you want to modify (please input the numbers before items)：");
//        System.out.println("1. Hall Name");
//        System.out.println("2. Description");
//        System.out.println("3. Address");
//        System.out.println("4. Contact Information");
//        System.out.println("5. Catering");
//        System.out.println("6. Photo");
//        System.out.println("7. Capacity");
//        Scanner sc = new Scanner(System.in);
//        int number = Integer.parseInt(sc.nextLine());
//        switch (number){
//            case 1:
//                System.out.print("Please input new hall name: ");
//                sc.nextLine();
//                System.out.println("Hall name update successfully!");
//                break;
//            case 2:
//                System.out.print("Please input new hall description: ");
//                sc.nextLine();
//                System.out.println("Description update successfully!");
//                break;
//            case 3:
//                System.out.print("Please input new hall address: ");
//                sc.nextLine();
//                System.out.println("Address update successfully!");
//                break;
//            case 4:
//                System.out.print("Please input new contact information: ");
//                sc.nextLine();
//                System.out.println("Contact information update successfully!");
//                break;
//            case 5:
//                System.out.print("Please input new catering information: ");
//                sc.nextLine();
//                System.out.println("Catering update successfully!");
//                break;
//            case 6:
//                System.out.print("Please input new hall photo: ");
//                sc.nextLine();
//                System.out.println("Photo update successfully!");
//                break;
//            case 7:
//                System.out.print("Please input new capacity of this hall: ");
//                sc.nextLine();
//                System.out.println("Capacity update successfully!");
//                break;
//        }
//    }
    public void incompleteFunction(){
        System.out.println("We are working on this function...Come back soon:)");
    }
    public void createHall() {
        incompleteFunction();
//        String name = "";
//        String desc = "";
//        String addr = "";
//        String cont = "";
//        boolean cate = false;
//        String photo = "";
//        int capacity = 0;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("===============Create A New Hall===============");
//        System.out.print("Hall Name: ");
//        name = sc.nextLine();
//        System.out.print("Description: ");
//        desc = sc.nextLine();
//        System.out.print("Address: ");
//        addr = sc.nextLine();
//        System.out.print("Contact Info: ");
//        cont = sc.nextLine();
//        System.out.print("Catering[Y/N]: ");
//        String yn = sc.nextLine();
//        if (yn == "Yes" || yn == "yes" || yn == "y" || yn == "Y")
//            cate = true;
//        System.out.print("Photo: ");
//        photo = sc.nextLine();
//        System.out.print("Capacity: ");
//        String number = sc.nextLine();
//        try {
//            capacity = Integer.parseInt(number);
//        }
//        catch(Exception ep){
//            System.out.print("Invalid input!");
//        }
//        System.out.print("Confirm of creating a new hall?[Y/N] ");
//        yn = sc.nextLine();
//        if (yn == "Yes" || yn == "yes" || yn == "y" || yn == "Y") {
//            Hall newHall = new Hall(name, desc, addr, cont, cate, photo, capacity);
//            System.out.print(newHall.toString());
//        }
//        else
//            System.out.println("Exit creating process..");
//        System.out.println("Press enter to continue...");
//        sc.nextLine();
    }

    public void customerMenu(){
        //Scanner sc = new Scanner(System.in);
        System.out.println("Hello, customer!");
        boolean flag = true;
        char choice = '0';
        while(flag) {
            System.out.println("====================Customer Menu===================");
            System.out.println("1. View all halls");
            System.out.println("2. Search for a hall");
            //System.out.println("3. Filter halls");
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
                /*case '3':
                    System.out.println("Filter halls here.");
                    break; */

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
    public void viewBookings(){
        controller.changeBooking();
        //incompleteFunction();
    }
    public void viewAllHalls()
    {
        System.out.println(controller.searchHalls("","name"));
        sendQuotation();
    }
    public void logout(){
        controller.logout();
        System.out.println("Goodbye.");
    }
    public void viewMyDiscounts() {
        incompleteFunction();
    }
    public void addDiscount(){
        incompleteFunction();
    }
    public void viewPayments(){
        incompleteFunction();
    }
    public void updateAccount(){
        incompleteFunction();
    }

    public boolean searchHallByName(){
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
    public boolean searchHallByAddr(){
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
    public boolean searchHallByCatar(){
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
    public boolean searchHallByCapacity(){
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
    public void sendQuotation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Send quotation function is incomplete...");
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
    /*public void bookAHall() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==================Quotation List====================");
        System.out.println("Hall 1: Monash Sports Center");
        System.out.println("Address: xxx, Clayton");
        System.out.println("Using date/time: 10am-5pm, 31/11/2019");
        System.out.println("Total Price: $500");
        System.out.println("====================================================");
        System.out.println("Please input the hall number above to make a booking:");
        System.out.println("(Enter 0 to home page.)");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 0)
            System.out.println("Return home page...");
        else if(choice != 1)
            System.out.println("Invalide input. Return to home page.");
        else
        {
            testDisplaySampleHall1();
            System.out.println("Total Price: $500");
            System.out.println("Are you sure you want to book this hall?[Y/N]");
            char input = sc.nextLine().charAt(0);
            if (input == 'Y' || input == 'y') {
                customerPayment();
                System.out.print("Successful payment!");
                displayReceipt();
            }
        }
    }*/
//    public void displayReceipt(){
//        System.out.println("************");
//        System.out.println("Receipt Here");
//        testDisplaySampleHall1();
//        System.out.println("Total Price: $500");
//        System.out.println("************");
//    }

//    public boolean customerPayment()
//    {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter to finish payment:");
//        sc.nextLine();
//        System.out.println("Payment completed");
//        return true;
//    }
//    public void requestQuot()
//    {
//        Scanner sc = new Scanner(System.in);
//        String occasion = "";
//        int numOfPeople = 0;
//        boolean cata = false;
//        String dateTime = "";
//        System.out.println("Please select a hall:");
//        int choice = Integer.parseInt(sc.nextLine());
//        if (choice == 1 || choice == 2)
//        {
//            System.out.println("Occasion types: ");
//            System.out.println("1. wedding ceremony");
//            System.out.println("2. wedding reception");
//            System.out.println("3. birthday");
//            System.out.println("4. anniversary");
//            System.out.print("Please select an occasion:");
//            occasion = sc.nextLine();
//            System.out.print("Number of people attending");
//            numOfPeople = Integer.parseInt(sc.nextLine());
//            System.out.print("Do you need catering service? [Y/N] ");
//            char input = sc.nextLine().charAt(0);
//            if (input == 'Y' || input == 'y')
//                cata = true;
//            System.out.print("Please enter the date and time of your event:");
//            dateTime = sc.nextLine();
//            System.out.println("Please check your request information:");
//            if (choice == 1) {
//                testDisplaySampleHall1();
//            }
//            else
//                testDisplaySampleHall2();
//            System.out.println("Occasion types - " + occasion);
//            System.out.println("Attend people number - " + numOfPeople);
//            if (cata == true)
//                System.out.println("Catering service: Yes");
//            else
//                System.out.println("Catering service: No");
//            System.out.println("Event date and time: " + dateTime);
//            System.out.println("Please confirm the quotation request information[Y/N]:");
//            input = sc.nextLine().charAt(0);
//            if (input == 'Y' || input == 'y')
//                System.out.println("Request send successfully!");
//        }
//        System.out.println("Return home page...");
//        System.out.println("Press enter to continue...");
//        sc.nextLine();
//    }

//    public void testDisplaySampleHall1()
//    {
//        System.out.println("====================================================");
//        System.out.println("Hall 1:");
//        System.out.println("Hall Name: Monash Sports Center");
//        System.out.println("Description: xxxxxxxxxxxxxx");
//        System.out.println("Address: xxx, Clayton");
//        System.out.println("Contact Info: xxxx@monash.edu");
//        System.out.println("Catering: Yes");
//        System.out.println("Photo: center.jpg");
//        System.out.println("Capacity: 200");
//
//    }
//    public void testDisplaySampleHall2(){
//        System.out.println("====================================================");
//        System.out.println("Hall 2:");
//        System.out.println("Hall Name: Monash Library");
//        System.out.println("Description: yyyyyyyyyyyyyy");
//        System.out.println("Address: xxx, Caulfield");
//        System.out.println("Contact Info: yyyy@monash.edu");
//        System.out.println("Catering: No");
//        System.out.println("Photo: library.jpg");
//        System.out.println("Capacity: 50");
//    }
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