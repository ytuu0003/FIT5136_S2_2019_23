import java.util.ArrayList;

public class DataHandler {
    ArrayList<Customer> listOfCustomers = new ArrayList<>();
    ArrayList<Owner> listOfOwners = new ArrayList<>();
    ArrayList<Hall> listOfHalls = new ArrayList<>();
    ArrayList<Booking> listOfBookings = new ArrayList<>();
    ArrayList<Quotation> listOfQuotations = new ArrayList<>();
    //ArrayList<Discount> listOfDiscounts = new ArrayList<>();
    //ArrayList<Concession> listOfConcessions = new ArrayList<>();

    public String readFile(String fileName){
        String fileInfo = "";
        return fileInfo;
    }
    public void writeToFile(String fileName, String message){

    }

    public void testData(){
        Customer cus1 = new Customer("101","123","Lucy","Huang","Caulfield","10021","");
        Customer cus2 = new Customer("102","111","Hazel","Li","CBD","10022","");
        listOfCustomers.add(cus1);
        listOfCustomers.add(cus2);
        Owner owner1 = new Owner("201","123","Alva","Ni","aaa","10023");
        Owner owner2 = new Owner("202","111","Kenny","Li","CBD","10024");
        listOfOwners.add(owner1);
        listOfOwners.add(owner2);
        Booking booking1 = new Booking("001","101","hall1","purpose",25,"191111",true,100.00,800.00,"");
        Booking booking2 = new Booking("002","102","hall2","purpose2",25,"191112",true,100.00,800.00,"");
        listOfBookings.add(booking1);
        listOfBookings.add(booking2);
        Hall hall1 = new Hall("hall1","desc1","addr1","12323123",true,"wefaf.com",43);
        Hall hall2 = new Hall("hall2","desc2","addr2","12323123",false,"wefaf.com",25);
        listOfHalls.add(hall1);
        listOfHalls.add(hall2);
        Quotation q1 = new Quotation();
        q1.testFile1();
        listOfQuotations.add(q1);
        Quotation q2 = new Quotation();
        q2.testFile2();
        listOfQuotations.add(q2);
        System.out.println(q1.displayQuotationInfo());
    }

    public ArrayList<Hall> getListOfHalls(){
        return listOfHalls;
    }
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
    //----------------------------Yushan Tu-------------------------------


}
