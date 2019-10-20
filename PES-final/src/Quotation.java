import java.lang.Math;

/**
 * This Quotation Class represents a quotation object in the system.
 * It used to generate a quotation object.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Quotation {
    private String customerId;
    private String hallId;
    private String ownerId;
    private double[] priceList = new double[3];
    private String quotationInfo;
    private int state;

    /**
     * Creates a quotation with default values on quotation information, price list, owner id,
     * hall id, customer id and its state
     *
     * */
    public Quotation(){
        quotationInfo = "";
        priceList = new double[]{0.0, 0.0, 0.0};
        ownerId = "";
        hallId = "";
        customerId = "";
        state = 0;
    }

    /**
     * Creates a quotation with quotation information, price list, owner id,
     * hall id, customer id and its state
     *
     * @param  newQuotationInfo The displayed information of this quotation.
     * @param  newPriceList The price, discount and deposit information of this quotation.
     * @param  newOwnerId TThe owner id who provides this quotation.
     * @param  newHallId The hall id on this quotation.
     * @param  newCustomerId The customer id who requests this quotation.
     * @param  newState The provided state of this quotation.
     * */
    public Quotation(String newQuotationInfo, double[] newPriceList, String newOwnerId, String newHallId, String newCustomerId, int newState){
        quotationInfo = newQuotationInfo;
        priceList = newPriceList;
        ownerId = newOwnerId;
        hallId = newHallId;
        customerId = newCustomerId;
        state = newState;
    }

    /**
     * Returns a string information of a particular quotation for display on the screen
     *
     * @return  A String object that contains the quotation details information.
     * */
    public String displayQuotationInfo(){
        String info = "";
        info = formatQuotationInfo() + "\nOwner ID: " + ownerId + "\nHall ID: " + hallId + "\nCustomer ID: "
                + customerId + "\nState: " + state;
        return info;
    }

    /**
     * Reformats a string information of a particular quotation for display on the screen
     *
     * @return  A String object that contains the quotation foundational information.
     * */
    public String formatQuotationInfo(){
        String quotationInfoFormat = "";
        String[] quotationFields = new String[6];
        quotationFields = quotationInfo.split(",",6);
        quotationInfoFormat += "Attendance: ";
        quotationInfoFormat = quotationInfoFormat + quotationFields[0] + "\n";
        quotationInfoFormat += "Catering: ";
        quotationInfoFormat = quotationInfoFormat + quotationFields[1] + "\n";
        quotationInfoFormat += "Date and Time: ";
        quotationInfoFormat = quotationInfoFormat + quotationFields[2] + "\n";
        quotationInfoFormat += "Event Type: ";
        quotationInfoFormat = quotationInfoFormat + quotationFields[4];

        return quotationInfoFormat;

    }

    /**
     * Gets the customer id of this quotation.
     *
     * @return A String object which contains customer id of this quotation.
     * */
    public String getCustomerId(){
        return customerId;
    }

    /**
     * Gets the hall id information of this quotation.
     *
     * @return A String object which contains hall id information of this quotation.
     * */
    public String getHallId(){
        return hallId;
    }

    /**
     * Gets the owner id information of this quotation.
     *
     * @return A String object which contains owner id information of this quotation.
     * */
    public String getOwnerId(){
        return ownerId;
    }

    /**
     * Gets the specific price information of this quotation, such as total price, discount and deposit.
     *
     * @return A String object which contains the specific price information of this quotation.
     * */
    public double getPriceList(int index){
        return priceList[index];
    }

    /**
     * Gets the displayed information of this quotation.
     *
     * @return A String object which contains displayed information of this quotation.
     * */
    public String getQuotationInfo(){
        return quotationInfo;
    }

    /**
     * Sets the quotation foundational information of a particular quotation.
     *
     * @param newInfo the quotation foundational information
     * */
    public void setQuotationInfo(String newInfo){
        quotationInfo = newInfo;
    }

    /**
     * Gets the state of this quotation.
     *
     * @return A String object which contains state of this quotation.
     * */
    public int getState(){
        return state;
    }

    /**
     * Sets the quotation state of a particular quotation.
     *
     * @param newState the quotation state
     * */
    public void setState(int newState){
        state = newState;
    }

    /**
     * Sets the quotation price list information of a particular quotation.
     *
     * @param price the quotation foundational information.
     * @param  discount the discount which this quotation could get
     * */
    public void setPriceList(double price, double discount){
        priceList[0] = price;
        priceList[1] = discount;
        priceList[2] = Math.round((price * (1 - discount) * 0.1) * 100.0) / 100.0;
    }



    /**
     * Splits the basic information which contains attendance number, catering service, date and time, deposit, purpose
     * and total price.
     *
     * @return  An array of String objects that contains the quotation foundational information.
     * */
    public String[] splitQuotationInfo(){
        return quotationInfo.split(",",6);
    }



    /**
     * Returns a string information of a particular quotation for display into database
     *
     * @return  A String object that contains the quotation details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(quotationInfo);
        dm.append(",");
        dm.append(priceList[0]);
        dm.append(",");
        dm.append(priceList[1]);
        dm.append(",");
        dm.append(priceList[2]);
        dm.append(",");
        dm.append(ownerId);
        dm.append(",");
        dm.append(hallId);
        dm.append(",");
        dm.append(customerId);
        dm.append(",");
        dm.append(state);
        return dm.toString();
    }
}
