import java.util.ArrayList;
import java.awt.datatransfer.ClipboardOwner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class DataHandler {
    ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
    ArrayList<Owner> listOfOwners = new ArrayList<Owner>();
    ArrayList<Hall> listOfHalls = new ArrayList<Hall>();
    ArrayList<Booking> listOfBookings = new ArrayList<Booking>();
    ArrayList<Quotation> listOfQuotations = new ArrayList<Quotation>();
    ArrayList<Discount> listOfDiscounts = new ArrayList<Discount>();
    ArrayList<Concession> listOfConcessions = new ArrayList<Concession>();

//    public String readFile(String fileName){
//        String fileInfo = "";
//        return fileInfo;
//    }
//    public void writeToFile(String fileName, String message){
//
//    }
//
//    public void testData(){
//        Customer cus1 = new Customer("101","123","Lucy","Huang","Caulfield","10021","");
//        Customer cus2 = new Customer("102","111","Hazel","Li","CBD","10022","");
//        listOfCustomers.add(cus1);
//        listOfCustomers.add(cus2);
//        Owner owner1 = new Owner("201","123","Alva","Ni","aaa","10023");
//        Owner owner2 = new Owner("202","111","Kenny","Li","CBD","10024");
//        listOfOwners.add(owner1);
//        listOfOwners.add(owner2);
//        Booking booking1 = new Booking("001","101","hall1","purpose",25,"191111",true,100.00,800.00,"");
//        Booking booking2 = new Booking("002","102","hall2","purpose2",25,"191112",true,100.00,800.00,"");
//        listOfBookings.add(booking1);
//        listOfBookings.add(booking2);
//        Hall hall1 = new Hall("hall1","desc1","addr1","12323123",true,"wefaf.com",43);
//        Hall hall2 = new Hall("hall2","desc2","addr2","12323123",false,"wefaf.com",25);
//        Hall hall3 = new Hall("hall3","desc3","addr3","12323123",true,"wefaf.com",10);
//        Hall hall4 = new Hall("hall4","desc4","addr4","12323123",false,"wefaf.com",100);
//        listOfHalls.add(hall1);
//        listOfHalls.add(hall2);
//        listOfHalls.add(hall3);
//        listOfHalls.add(hall4);
//        Quotation q1 = new Quotation();
//        q1.testFile1();
//        listOfQuotations.add(q1);
//        Quotation q2 = new Quotation();
//        q2.testFile2();
//        listOfQuotations.add(q2);
//        System.out.println(q1.displayQuotationInfo());
//    }

   // public ArrayList<Hall> getListOfHalls(){
     //   return listOfHalls;
  //  }
//-----------------------------Yushan Tu-------------------------------
    public Customer validateCustomer(String id, String pwd){
        for (Customer c : listOfCustomers){
            if (c.getUserId().equals(id))
                if (c.getPassword().equals(pwd))
                    return c;
        }
        return null;
    }

    public Owner validateOwner(String id, String pwd){
        for (Owner o : listOfOwners){
            if (o.getUserId().equals(id))
                if (o.getPassword().equals(pwd))
                    return o;
        }
        return null;
    }

    public void addCustomer(Customer customer){
        listOfCustomers.add(customer);
    }

    public void addOwner(Owner owner){
        listOfOwners.add(owner);
    }

    public void addBooking(Booking newBooking){
        listOfBookings.add(newBooking);
    }
    //----------------------------Yushan Tu-------------------------------
    public ArrayList<Customer> getListOfCustomers(){
        return  listOfCustomers;
    }

    public ArrayList<Owner> getListOfOwner() {
        return listOfOwners;
    }

    public ArrayList<Hall> getListOfHalls() {
        return listOfHalls;
    }

    public ArrayList<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public ArrayList<Quotation> getListOfQuotations() {
        return listOfQuotations;
    }

    public ArrayList<Discount> getListOfDiscounts() {
        return listOfDiscounts;
    }

    public ArrayList<Concession> getListOfConcessions() {
        return listOfConcessions;
    }

    public void setListOfCustomers(ArrayList<Customer> customerArrayList) {
        listOfCustomers = customerArrayList;
    }

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
            String dnt = info[5];
            boolean cat = Boolean.parseBoolean(info[6]);
            double dp = Double.parseDouble(info[7]);
            double tp = Double.parseDouble(info[8]);
            String rw = info[9];
            Booking nk = new Booking(BID, CID, HID, purp, atted, dnt, cat, dp, tp, rw);
            listOfBookings.add(nk);
        }
    }

    public void readCustomerFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("customerList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String cuInfo = parser.nextLine();

            String[] info = cuInfo.split(",");
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

    public void readHallFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("hallList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String hallInfo = parser.nextLine();
            String[] info = hallInfo.split(",");
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

    public void readOwnerFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("ownerList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String ownerInfo = parser.nextLine();

            String[] info = ownerInfo.split(",");
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

    public void readQuotationFile() throws FileNotFoundException {
        FileReader inputFile = new FileReader("quotationList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String quotaInfo = parser.nextLine();
            String[] info = quotaInfo.split(",");
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

    public void readDiscountFile() throws FileNotFoundException{
        FileReader inputFile = new FileReader("discountList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String quotaInfo = parser.nextLine();
            String[] info = quotaInfo.split(",");
            String pn = info[0];
            double pr = Double.parseDouble(info[1]);
            Discount nd = new Discount(pn, pr);
            listOfDiscounts.add(nd);
        }
    }

    public void readConcession() throws FileNotFoundException{
        FileReader inputFile = new FileReader("concessionList.txt");
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine()) {
            String quotaInfo = parser.nextLine();
            String[] info = quotaInfo.split(",");
            String toc = info[0];
            double pr = Double.parseDouble(info[1]);
            Concession nc = new Concession(toc, pr);
            listOfConcessions.add(nc);
        }
    }

    public void writeToBookingFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("bookingList.txt");
        Iterator<Booking> it = listOfBookings.iterator();
        while (it.hasNext()){
            Booking bk = it.next();
            outputFile.println(bk.toStringItrem());
        }
        outputFile.close();
    }

    public void writeToCustomerFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("customerList.txt");
        Iterator<Customer> it = listOfCustomers.iterator();
        while (it.hasNext()){
            Customer ct = it.next();
            outputFile.println(ct.toStringItem());
        }
        outputFile.close();
    }

    public void writeToHallFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("hallList.txt");
        Iterator<Hall> it = listOfHalls.iterator();
        while (it.hasNext()){
            Hall hl = it.next();
            outputFile.println(hl.toStringItem());
        }
        outputFile.close();
    }

    public void writeToOwnerFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("ownerList.txt");
        Iterator<Owner> it = listOfOwners.iterator();
        while (it.hasNext()){
            Owner ow = it.next();
            outputFile.println(ow.toStringItem());
        }
        outputFile.close();
    }

    public void writeToQuotationFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("quotationList.txt");
        Iterator<Quotation> it = listOfQuotations.iterator();
        while (it.hasNext()){
            Quotation qt = it.next();
            outputFile.println(qt.toStringItem());
        }
        outputFile.close();
    }

    public void writeToDiscountFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("discountList.txt");
        Iterator<Discount> it = listOfDiscounts.iterator();
        while (it.hasNext()){
            Discount dc = it.next();
            outputFile.println(dc.toStringItem());
        }
        outputFile.close();
    }

    public void writeToConcessionFile() throws FileNotFoundException{
        PrintWriter outputFile = new PrintWriter("concessionList.txt");
        Iterator<Concession> it = listOfConcessions.iterator();
        while (it.hasNext()){
            Concession cc = it.next();
            outputFile.println(cc.toStringItem());
        }
        outputFile.close();
    }

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
            return false;
        }

    }

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
