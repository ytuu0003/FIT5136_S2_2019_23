import java.util.ArrayList;
import java.awt.datatransfer.ClipboardOwner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This DataHandler Class represents a data handler object in the system.
 * It used to generate a data handler object to read and write data between system and file.
 *
 * @author Tushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class DataHandler {
    ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
    ArrayList<Owner> listOfOwners = new ArrayList<Owner>();
    ArrayList<Hall> listOfHalls = new ArrayList<Hall>();
    ArrayList<Booking> listOfBookings = new ArrayList<Booking>();
    ArrayList<Quotation> listOfQuotations = new ArrayList<Quotation>();
    ArrayList<Discount> listOfDiscounts = new ArrayList<Discount>();
    ArrayList<Concession> listOfConcessions = new ArrayList<Concession>();

    /**
     * Checks whether the particular customer exist in the file or not and the password is correct or not
     *
     * @param id The id of this customer.
     * @param pwd The password of this customer.
     *
     * @return this customer object if correct otherwise return null.
     * */
    public Customer validateCustomer(String id, String pwd){
        for (Customer c : listOfCustomers){
            if (c.getUserId().equals(id))
                if (c.getPassword().equals(pwd))
                    return c;
        }
        return null;
    }

    /**
     * Checks whether the particular owner exist in the file or not and the password is correct or not
     *
     * @param id The id of this owner.
     * @param pwd The password of this owner.
     *
     * @return this owner object if correct otherwise return null.
     * */
    public Owner validateOwner(String id, String pwd){
        for (Owner o : listOfOwners){
            if (o.getUserId().equals(id))
                if (o.getPassword().equals(pwd))
                    return o;
        }
        return null;
    }

    /**
     * Adds a particular customer into the list of customer objects
     *
     * @param customer The customer which needed to add into the list.
     *
     * */
    public void addCustomer(Customer customer){
        listOfCustomers.add(customer);
    }

    /**
     * Adds a particular owner into the list of owner objects
     *
     * @param owner The owner which needed to add into the list.
     *
     * */
    public void addOwner(Owner owner){
        listOfOwners.add(owner);
    }

    /**
     * Adds a particular booking into the list of booking objects
     *
     * @param newBooking The booking which needed to add into the list.
     *
     * */
    public void addBooking(Booking newBooking){
        listOfBookings.add(newBooking);
    }

    /**
     * Gets an array list of customer objectives
     * @return an array list of customer objectives
     * */
    public ArrayList<Customer> getListOfCustomers(){
        return  listOfCustomers;
    }

    /**
     * Gets an array list of owner objectives
     * @return an array list of owner objectives
     * */
    public ArrayList<Owner> getListOfOwner() {
        return listOfOwners;
    }

    /**
     * Gets an array list of hall objectives
     * @return an array list of hall objectives
     * */
    public ArrayList<Hall> getListOfHalls() {
        return listOfHalls;
    }

    /**
     * Gets an array list of booking objectives
     * @return an array list of booking objectives
     * */
    public ArrayList<Booking> getListOfBookings() {
        return listOfBookings;
    }

    /**
     * Gets an array list of quotation objectives
     * @return an array list of quotation objectives
     * */
    public ArrayList<Quotation> getListOfQuotations() {
        return listOfQuotations;
    }

    /**
     * Gets an array list of discount objectives
     * @return an array list of discount objectives
     * */
    public ArrayList<Discount> getListOfDiscounts() {
        return listOfDiscounts;
    }

    /**
     * Gets an array list of concession objectives
     * @return an array list of concession objectives
     * */
    public ArrayList<Concession> getListOfConcessions() {
        return listOfConcessions;
    }

    /**
     * Reads the Booking List from file into system and generate an arrayList of booking objects.
     * */
    public void readBookingFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("bookingList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String bkInfo = parser.nextLine();
            String[] info = bkInfo.split(",",10);
            String BID = info[0];
            String CID = info[1];
            String HID = info[2];
            String purp = info[3];
            int atted = Integer.parseInt(info[4]);
            //*************************yushan tu****************************
            int dnt = Integer.parseInt(info[5]);
            boolean cat = Boolean.parseBoolean(info[6]);
            double dp = Double.parseDouble(info[7]);
            double tp = Double.parseDouble(info[8]);
            String rw = info[9];
            Booking nk = new Booking(BID, CID, HID, purp, atted, dnt, cat, dp, tp, rw);
            listOfBookings.add(nk);
        }
    }

    /**
     * Reads the Customer List from file into system and generate an arrayList of customer objects.
     * */
    public void readCustomerFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("customerList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String cuInfo = parser.nextLine();

            String[] info = cuInfo.split(",",7);
            String CID = info[0];
            String PWD = info[1];
            String FN = info[2];
            String LN = info[3];
            String address = info[4];
            String ph = info[5];
            String ty = info[6];
            Customer ct = new Customer(CID, PWD, FN, LN, address, ph, ty);
            listOfCustomers.add(ct);
        }
    }

    /**
     * Reads the hall List from file into system and generate an arrayList of hall objects.
     * */
    public void readHallFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("hallList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String hallInfo = parser.nextLine();
            String[] info = hallInfo.split(",",11);
            String HID = info[0];
            String name = info[1];
            String OID = info[2];
            String desc = info[3];
            String address = info[4];
            String contact = info[5];
            String tyOfOccasion = info[6];
            boolean ct = Boolean.parseBoolean(info[7]);
            String photo = info[8];
            int capacity = Integer.parseInt(info[9]);
            double price = Double.parseDouble(info[10]);
            Hall newHall = new Hall(HID, name, OID, desc, address, contact, tyOfOccasion, ct, photo, capacity, price);
            listOfHalls.add(newHall);

        }
    }

    /**
     * Reads the Owner List from file into system and generate an arrayList of owner objects.
     * */
    public void readOwnerFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("ownerList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String ownerInfo = parser.nextLine();

            String[] info = ownerInfo.split(",",6);
            String UID = info[0];
            String PWD = info[1];
            String FN = info[2];
            String LN = info[3];
            String address = info[4];
            String ph = info[5];
            Owner ow = new Owner(UID, PWD, FN, LN, address, ph);
            listOfOwners.add(ow);
        }
    }

    /**
     * Reads the Quotation List from file into system and generate an arrayList of quotation objects.
     * */
    public void readQuotationFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("quotationList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String quotaInfo = parser.nextLine();
            String[] info = quotaInfo.split(",",13);
            StringBuffer qif = new StringBuffer();
            String attendence = info[0];
            String cater = info[1];
            String dnt = info[2];
            String dp = info[3];
            String purp = info[4];
            String tp = info[5];
            double price = Double.parseDouble(info[6]);
            double discount = Double.parseDouble(info[7]);
            double deposit = Double.parseDouble(info[8]);
            String OID = info[9];
            String HID = info[10];
            String CID = info[11];
            int state = Integer.parseInt(info[12]);
            qif.append(attendence);
            qif.append(",");
            qif.append(cater);
            qif.append(",");
            qif.append(dnt);
            qif.append(",");
            qif.append(dp);
            qif.append(",");
            qif.append(purp);
            qif.append(",");
            qif.append(tp);
            String QIF = qif.toString();
            double[] plist = new double[3];
            plist[0] = price;
            plist[1] = discount;
            plist[2] = deposit;
            Quotation nq = new Quotation(QIF, plist, OID, HID, CID, state);
            listOfQuotations.add(nq);
        }
    }

    /**
     * Reads the Discount List from file into system and generate an arrayList of discount objects.
     * */
    public void readDiscountFile() throws FileNotFoundException{
        FileReader inputFile = new FileReader("discountList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String quotaInfo = parser.nextLine();
            String[] info = quotaInfo.split(",",2);
            String pn = info[0];
            double pr = Double.parseDouble(info[1]);
            Discount nd = new Discount(pn, pr);
            listOfDiscounts.add(nd);
        }
    }

    /**
     * Reads the Concession List from file into system and generate an arrayList of concession objects.
     * */
    public void readConcession() throws FileNotFoundException{
        FileReader inputFile = new FileReader("concessionList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String quotaInfo = parser.nextLine();
            String[] info = quotaInfo.split(",",2);
            String toc = info[0];
            double pr = Double.parseDouble(info[1]);
            Concession nc = new Concession(toc, pr);
            listOfConcessions.add(nc);
        }
    }

    /**
     * Writes the arrayList of booking objects from system into Booking List file.
     * */
    public void writeToBookingFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("bookingList.txt");
        Iterator<Booking> it = listOfBookings.iterator();
        while (it.hasNext()){
            Booking bk = it.next();
            outputFile.println(bk.toStringItrem());
        }
        outputFile.close();
    }


    /**
     * Writes the arrayList of customer objects from system into Customer List file.
     * */
    public void writeToCustomerFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("customerList.txt");
        Iterator<Customer> it = listOfCustomers.iterator();
        while (it.hasNext()){
            Customer ct = it.next();
            outputFile.println(ct.toStringItem());
        }
        outputFile.close();
    }

    /**
     * Writes the arrayList of hall objects from system into Hall List file.
     * */
    public void writeToHallFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("hallList.txt");
        Iterator<Hall> it = listOfHalls.iterator();
        while (it.hasNext()){
            Hall hl = it.next();
            outputFile.println(hl.toStringItem());
        }
        outputFile.close();
    }

    /**
     * Writes the arrayList of owner objects from system into Owner List file.
     * */
    public void writeToOwnerFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("ownerList.txt");
        Iterator<Owner> it = listOfOwners.iterator();
        while (it.hasNext()){
            Owner ow = it.next();
            outputFile.println(ow.toStringItem());
        }
        outputFile.close();
    }

    /**
     * Writes the arrayList of quotation objects from system into Quotation List file.
     * */
    public void writeToQuotationFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("quotationList.txt");
        Iterator<Quotation> it = listOfQuotations.iterator();
        while (it.hasNext()){
            Quotation qt = it.next();
            outputFile.println(qt.toStringItem());
        }
        outputFile.close();
    }

    /**
     * Writes the arrayList of discount objects from system into Discount List file.
     * */
    public void writeToDiscountFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("discountList.txt");
        Iterator<Discount> it = listOfDiscounts.iterator();
        while (it.hasNext()){
            Discount dc = it.next();
            outputFile.println(dc.toStringItem());
        }
        outputFile.close();
    }

    /**
     * Writes the arrayList of concssion objects from system into Concession List file.
     * */
    public void writeToConcessionFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("concessionList.txt");
        Iterator<Concession> it = listOfConcessions.iterator();
        while (it.hasNext()){
            Concession cc = it.next();
            outputFile.println(cc.toStringItem());
        }
        outputFile.close();
    }

    /**
     * Reads all lists from files into system and generate all array list of objects
     *
     * @return the state about initializing successfully or not
     * */
    public boolean initialList() {
        try {
            readHallFile();
            readOwnerFile();
            readCustomerFile();
            readBookingFile();
            readQuotationFile();
            readDiscountFile();
            readConcession();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    /**
     * Write all array list of objects from system into files
     *
     * @return the state about updating successfully or not
     * */
    public boolean updateList(){
        try{
            writeToCustomerFile();
            writeToBookingFile();
            writeToConcessionFile();
            writeToDiscountFile();
            writeToHallFile();
            writeToOwnerFile();
            writeToQuotationFile();
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Write to file Error...");
            return false;
        }

    }

    /**
     * Clears all lists of objects in the memory.
     * */
    public void cleanList(){
        listOfCustomers.clear();
        listOfConcessions.clear();
        listOfOwners.clear();
        listOfDiscounts.clear();
        listOfHalls.clear();
        listOfBookings.clear();
        listOfQuotations.clear();
    }
}
