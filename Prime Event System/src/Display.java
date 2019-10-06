import java.util.Scanner;

public class Display {

    /*public static void main(String[] args) {
        Display dp = new Display();
        dp.login();
    }*/
    public String login(){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        char choice = 'D';
        String email = "";
        String pw = "";
        String returnString = "";
        while(flag) {
            System.out.println("Welcome to Prime Event System!");
            System.out.println("Please login first.(Select your user identity type)");
            System.out.println("A. Customer");
            System.out.println("B. Property Owner");
            System.out.println("C. Administrator");
            System.out.println("D. Don't have an account yet.(Register now!)");
            System.out.println("E. Exit system");

            choice = sc.nextLine().charAt(0);
            flag = false;

            switch(choice){
                case 'A': case 'a':
                    System.out.println("Please enter customer user ID (Your Email address):");
                    email = sc.nextLine();
                    System.out.println("Please enter user password (Input 0000 if you forget your password):");
                    pw = sc.nextLine();
                    if (pw.equals("0000")){
                        pw = forgetPassword();
                        //returnString += "0 "; //reset password flag
                    }
                    returnString += "A,";
                    returnString += email + "," + pw;
                    //customerMenu(email);
                    break;
                case 'B': case 'b':
                    System.out.println("Please enter property owner user ID (Your Email address):");
                    email = sc.nextLine();
                    System.out.println("Please enter user password (Input 0000 if you forget your password):");
                    pw = sc.nextLine();
                    if (pw.equals("0000")){
                        pw = forgetPassword();
                        //returnString += "0 "; //reset password flag
                        }
                    //ownerMenu(email);
                    returnString += "B,";
                    returnString += email + "," + pw;
                    break;
                case 'C': case 'c':
                    System.out.println("Please enter administriter ID:");
                    email = sc.nextLine();
                    System.out.println("Please enter user password:");
                    pw = sc.nextLine();
                    returnString += "C,";
                    returnString += email + "," + pw;
                    break;
                case 'D': case 'd':
                    System.out.println("Please enter the account type you want to register");
                    System.out.println("('C' for customer or 'O' for property owner):");
                    String userType = sc.nextLine();
                    if (userType.charAt(0) == 'C' || userType.charAt(0) == 'c')
                        returnString += "1,";
                    else if (userType.charAt(0) == 'O' || userType.charAt(0) == 'o')
                        returnString += "2,";
                    else{
                        System.out.println("Invalid input!");
                        flag = true;
                        break;
                    }
                    System.out.println("Please enter user ID (Your Email address):");
                    email = sc.nextLine();
                    pw = inputPassword();
                    returnString += "D";
                    returnString += email + "," + pw;
                    break;
                case 'E': case 'e':
                    System.out.println("Exit...Goodbye!");
                    //flag = false;
                    returnString += "E ";
                    break;
                default:
                    System.out.println("Invalid input. Please select again:");
                    flag = true;
                    break;
            }
        }
        return returnString;
    }

    private String inputPassword() {
        Scanner sc = new Scanner(System.in);
        String pw = "";
        String pw1 = "";
        String pw2 = "";
        while(true) {
            System.out.println("Please enter user password:");
            pw1 = sc.nextLine();
            System.out.println("Confirm password:");
            pw2 = sc.nextLine();
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
    public void ownerMenu(String email){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, " + email + "!");
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

            choice = sc.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    viewMyHall();
                    break;
                case '2':
                    createHall();
                    break;
                case '3':
                    System.out.println("/*View hall discounts here.*/");
                    break;
                case '4':
                    System.out.println("/*Add a discount.*/");
                    break;
                case '5':
                    System.out.println("/*View requests.*/");
                    break;
                case '6':
                    System.out.println("/*View payment here.*/");
                    break;
                case '7':
                    System.out.println("/*Update account information here*/");
                case '8':
                    inputPassword();
                    break;
                case '9':
                    flag = false;
                    logout(email);
                    break;
            }
        }
    }

    public void viewMyHall() {
        testDisplaySampleHall1();
        testDisplaySampleHall2();
        System.out.println("====================================================");
        System.out.println("Please input hall number you want to edit:");
        System.out.println("(Input 0 or invaild symbol to return home page)");
        Scanner sc = new Scanner(System.in);
        char choice = '0';
        choice = sc.nextLine().charAt(0);
        if (choice == '1')
            editHall('1');
        else if (choice == '2')
            editHall('2');
    }
    public void editHall(char num) {
        System.out.println("Please select the item you want to modify (please input the numbers before items)：");
        System.out.println("1. Hall Name");
        System.out.println("2. Description");
        System.out.println("3. Address");
        System.out.println("4. Contact Information");
        System.out.println("5. Catering");
        System.out.println("6. Photo");
        System.out.println("7. Capacity");
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        switch (number){
            case 1:
                System.out.print("Please input new hall name: ");
                sc.nextLine();
                System.out.println("Hall name update successfully!");
                break;
            case 2:
                System.out.print("Please input new hall description: ");
                sc.nextLine();
                System.out.println("Description update successfully!");
                break;
            case 3:
                System.out.print("Please input new hall address: ");
                sc.nextLine();
                System.out.println("Address update successfully!");
                break;
            case 4:
                System.out.print("Please input new contact information: ");
                sc.nextLine();
                System.out.println("Contact information update successfully!");
                break;
            case 5:
                System.out.print("Please input new catering information: ");
                sc.nextLine();
                System.out.println("Catering update successfully!");
                break;
            case 6:
                System.out.print("Please input new hall photo: ");
                sc.nextLine();
                System.out.println("Photo update successfully!");
                break;
            case 7:
                System.out.print("Please input new capacity of this hall: ");
                sc.nextLine();
                System.out.println("Capacity update successfully!");
                break;
        }
    }

    public void createHall() {
        String name = "";
        String desc = "";
        String addr = "";
        String cont = "";
        boolean cate = false;
        String photo = "";
        int capacity = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("===============Create A New Hall===============");
        System.out.print("Hall Name: ");
        name = sc.nextLine();
        System.out.print("Description: ");
        desc = sc.nextLine();
        System.out.print("Address: ");
        addr = sc.nextLine();
        System.out.print("Contact Info: ");
        cont = sc.nextLine();
        System.out.print("Catering[Y/N]: ");
        String yn = sc.nextLine();
        if (yn == "Yes" || yn == "yes" || yn == "y" || yn == "Y")
            cate = true;
        System.out.print("Photo: ");
        photo = sc.nextLine();
        System.out.print("Capacity: ");
        String number = sc.nextLine();
        try {
            capacity = Integer.parseInt(number);
        }
        catch(Exception ep){
            System.out.print("Invalid input!");
        }
        System.out.print("Confirm of creating a new hall?[Y/N] ");
        yn = sc.nextLine();
        if (yn == "Yes" || yn == "yes" || yn == "y" || yn == "Y") {
            Hall newHall = new Hall(name, desc, addr, cont, cate, photo, capacity);
            System.out.print(newHall.display());
        }
        else
            System.out.println("Exit creating process..");
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }

    public void customerMenu(String email){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, " + email + "!");
        boolean flag = true;
        char choice = '0';
        while(flag) {
            System.out.println("====================Customer Menu===================");
            System.out.println("1. View all halls");
            System.out.println("2. Search for a hall");
            System.out.println("3. Filter halls");
            System.out.println("4. View booking");
            System.out.println("5. Book a hall");
            System.out.println("6. Update account information");
            System.out.println("7. Reset password");
            System.out.println("8. Logout");
            System.out.println("====================================================");

            choice = sc.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    viewAllHalls();
                    break;
                case '2':
                    searchHall();
                    break;
                case '3':
                    System.out.println("/*Filter halls here.*/");
                    break;
                case '4':
                    System.out.println("/*View booking here.*/");
                    break;
                case '5':
                    bookAHall();
                    break;
                case '6':
                    System.out.println("/*Update account information here*/");
                    break;
                case '7':
                    inputPassword();
                    break;
                case '8':
                    flag = false;
                    logout(email);
                    break;
            }
        }
    }
    public void viewAllHalls()
    {
        Scanner sc = new Scanner(System.in);
        testDisplaySampleHall1();
        testDisplaySampleHall2();
        System.out.println("Request a quotation now? [Y/N]");
        char input = sc.nextLine().charAt(0);
        if (input == 'Y' || input == 'y') {
            requestQuot();
        }
        else {
            System.out.println("No quotation Requestion needed. Return home page...");
            System.out.println("Enter to continue....");
            sc.nextLine();
        }
    }
    public void logout(String email){
        System.out.println("Goodbye, " + email + ".");
    }
    public void searchHall(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===================Search Hall==================");
        System.out.println("Please input hall name:");
        String name = sc.nextLine();
        if (name.equalsIgnoreCase("Monash"))
        {
            testDisplaySampleHall1();
            testDisplaySampleHall2();
        }
        else if (name.equalsIgnoreCase("monash sports center")){
            testDisplaySampleHall1();
        }
        System.out.println("Request a quotation now? [Y/N]");
        char input = sc.nextLine().charAt(0);
        if (input == 'Y' || input == 'y'){
            requestQuot();
        }
        else {
            System.out.println("No quotation Requestion needed. Return home page...");
            System.out.println("Enter to continue....");
            sc.nextLine();
        }
    }
    public void bookAHall() {
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
    }
    public void displayReceipt(){
        System.out.println("************");
        System.out.println("Receipt Here");
        testDisplaySampleHall1();
        System.out.println("Total Price: $500");
        System.out.println("************");
    }

    public boolean customerPayment()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter to finish payment:");
        sc.nextLine();
        System.out.println("Payment completed");
        return true;
    }
    public void requestQuot()
    {
        Scanner sc = new Scanner(System.in);
        String occasion = "";
        int numOfPeople = 0;
        boolean cata = false;
        String dateTime = "";
        System.out.println("Please select a hall:");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1 || choice == 2)
        {
            System.out.println("Occasion types: ");
            System.out.println("1. wedding ceremony");
            System.out.println("2. wedding reception");
            System.out.println("3. birthday");
            System.out.println("4. anniversary");
            System.out.print("Please select an occasion:");
            occasion = sc.nextLine();
            System.out.print("Number of people attending");
            numOfPeople = Integer.parseInt(sc.nextLine());
            System.out.print("Do you need catering service? [Y/N] ");
            char input = sc.nextLine().charAt(0);
            if (input == 'Y' || input == 'y')
                cata = true;
            System.out.print("Please enter the date and time of your event:");
            dateTime = sc.nextLine();
            System.out.println("Please check your request information:");
            if (choice == 1) {
                testDisplaySampleHall1();
            }
            else
                testDisplaySampleHall2();
            System.out.println("Occasion types - " + occasion);
            System.out.println("Attend people number - " + numOfPeople);
            if (cata == true)
                System.out.println("Catering service: Yes");
            else
                System.out.println("Catering service: No");
            System.out.println("Event date and time: " + dateTime);
            System.out.println("Please confirm the quotation request information[Y/N]:");
            input = sc.nextLine().charAt(0);
            if (input == 'Y' || input == 'y')
                System.out.println("Request send successfully!");
        }
        System.out.println("Return home page...");
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }

    public void testDisplaySampleHall1()
    {
        System.out.println("====================================================");
        System.out.println("Hall 1:");
        System.out.println("Hall Name: Monash Sports Center");
        System.out.println("Description: xxxxxxxxxxxxxx");
        System.out.println("Address: xxx, Clayton");
        System.out.println("Contact Info: xxxx@monash.edu");
        System.out.println("Catering: Yes");
        System.out.println("Photo: center.jpg");
        System.out.println("Capacity: 200");

    }
    public void testDisplaySampleHall2(){
        System.out.println("====================================================");
        System.out.println("Hall 2:");
        System.out.println("Hall Name: Monash Library");
        System.out.println("Description: yyyyyyyyyyyyyy");
        System.out.println("Address: xxx, Caulfield");
        System.out.println("Contact Info: yyyy@monash.edu");
        System.out.println("Catering: No");
        System.out.println("Photo: library.jpg");
        System.out.println("Capacity: 50");
    }
    public void displayMessage(String message){
        System.out.println(message);
    }
}
