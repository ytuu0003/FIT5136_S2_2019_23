/**
 * This Booking Class represents a booking object in the system.
 * It used to generate a booking object.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Booking {
    private String bookingID;
    private String customerId;
    private String hallId;
    private String purpose;
    private int attendance;
    private int dateAndTime;
    private boolean catering;
    private double deposit;
    private double totalPrice;
    private String review;

    /**
     * Creates a booking with default values on booking id, customer id, hall id, purpose, attendance, date and time, catering,
     * deposit, total price and review.
     *
     * */
    public Booking(){
        bookingID = "";
        customerId = "";
        hallId = "";
        purpose = "";

        attendance = 0;
        dateAndTime = 0;
        catering = false;
        deposit = 0.0;
        totalPrice = 0.0;
        review = "";
    }

    /**
     * Creates a booking with a booking id, customer id who creates this booking, hall id,
     * purpose, attendance number, date and time, catering service, deposit, total price and review.
     *
     * @param  BID The id of a booking.
     * @param  CID The customer id of this booking.
     * @param  HID The hall id of this booking.
     * @param  purp The purpose of this booking.
     * @param  atted The attendance of this booing.
     * @param  dnt The date and time of this booking.
     * @param  cat The provided catering or not of this booking.
     * @param  dp The deposit of this booking.
     * @param  tp  The total price of this booking.
     * @param  rw The review of this booking.
     * */
    public Booking(String BID, String CID, String HID, String purp, int atted, int dnt, boolean cat, double dp, double tp, String rw){
        bookingID = BID;
        customerId = CID;
        hallId = HID;
        purpose = purp;
        attendance = atted;
        dateAndTime = dnt;
        catering = cat;
        deposit = dp;
        totalPrice = tp;
        review = rw;
    }

    /**
     * Gets the attendance number of this booking
     *
     * @return A String object which contains the attendance number information.
     * */
    public int getAttendance(){
        return attendance;
    }

    /**
     * Gets the id of a booking
     *
     * @return A String object which contains the booking id information.
     * */
    public String getBookingID(){
        return bookingID;
    }

    /**
     * Gets the catering service of this booking
     *
     * @return A boolean value which contains the catering service information.
     * */
    public boolean getCater(){
        return catering;
    }

    /**
     * Gets the id of a user who has this booking
     *
     * @return A String object which contains the user id information.
     * */
    public String getCustId(){
        return customerId;
    }

    /**
     * Gets the date and time of this booking
     *
     * @return A String object which contains the date and time information.
     * */
    public int getDateAndTime(){
        return dateAndTime;
    }

    /**
     * Gets the deposit of this booking
     *
     * @return A double value which contains the deposit information.
     * */
    public double getDeposit(){
        return deposit;
    }

    /**
     * Gets the id of hall which is booked
     *
     * @return A String object which contains the hall id information.
     * */
    public String getHallId(){
        return hallId;
    }

    /**
     * Gets the purpose of this booking
     *
     * @return A String object which contains the purpose information.
     * */
    public String getPurpose(){
        return purpose;
    }

    /**
     * Gets the review of this booking
     *
     * @return A String object which contains the review information.
     * */
    public String getReview(){
        return review;
    }

    /**
     * Gets the total price of this booking
     *
     * @return A double valye which contains the total price information.
     * */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * Sets the attendance of a particular booking.
     *
     * @param atted the booking attendance information
     * */
    public void setAttendance(int atted){
        attendance = atted;
    }

    /**
     * Sets the booking id of a particular booking.
     *
     * @param BID the new booking id information
     * */
    public void setBookingID(String BID){
        bookingID = BID;
    }

    /**
     * Sets the catering of a particular booking.
     *
     * @param cat the catering service information
     * */
    public void setCater(boolean cat){
        catering = cat;
    }

    /**
     * Sets the customer id who has this booking.
     *
     * @param CID the customer id information
     * */
    public void setCustomerId(String CID){
        customerId = CID;
    }

    /**
     * Sets the date and time of a particular booking.
     *
     * @param dnt the new booking date and time information
     * */
    public void setDateAndTime(int dnt){
        dateAndTime = dnt;
    }

    /**
     * Sets the deposit of a particular booking.
     *
     * @param dp the deposit information
     * */
    public void setDeposit(double dp){
        deposit = dp;
    }

    /**
     * Sets the hall id which gets booked in this booking.
     *
     * @param HID the customer id information
     * */
    public void setHallId(String HID){
        hallId = HID;
    }

    /**
     * Sets the purpose of a particular booking.
     *
     * @param purp the new booking purpose information
     * */
    public void setPurpose(String purp){
        purpose = purp;
    }

    /**
     * Sets the review of a particular booking.
     *
     * @param rw the review  information
     * */
    public void setReview(String rw) {
        review = rw;
    }

    /**
     * Sets the total price of a particular booking.
     *
     * @param tp the total price information
     * */
    public void setTotalPrice(double tp){
        totalPrice = tp;
    }

    /**
     * Returns a string information of a particular booking for display
     *
     * @return  A String object that contains the booking details information.
     * */
    public String toString(){
        String displayMessage = "";
        displayMessage += "BookingID: " + bookingID + "\n";
        displayMessage += "CustomerID: " + customerId + "\n";
        displayMessage += "HallID: " + hallId + "\n";
        displayMessage += "Purpose: " + purpose + "\n";
        displayMessage += "Attendance: " + attendance + "\n";
        displayMessage += "Date and Time: " + dateAndTime + "\n";
        displayMessage += "Catering: " + catering + "\n";
        displayMessage += "Deposit: " + deposit + "\n";
        displayMessage += "Total Price: " + totalPrice + "\n";
        displayMessage += "Review: " + review + "\n";

        return displayMessage;
    }

    /**
     * Returns a string information of a particular booking
     *
     * @return  A String object that contains the booking details information.
     * */
    public String toStringItrem() {
        String displayMessage = "";
        displayMessage += bookingID + ",";
        displayMessage += customerId + ",";
        displayMessage += hallId + ",";
        displayMessage += purpose + ",";
        displayMessage += attendance + ",";
        displayMessage += dateAndTime + ",";
        displayMessage += catering + ",";
        displayMessage += deposit + ",";
        displayMessage += totalPrice + ",";
        displayMessage += review;

        return displayMessage;
    }
}
