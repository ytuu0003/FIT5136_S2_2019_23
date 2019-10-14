public class Booking {
    private String bookingID;
    private String customerId;
    private String hallId;
    private String purpose;
    private int attendance;
    private String dateAndTime;
    private boolean catering;
    private double deposit;
    private double totalPrice;
    private String review;

    public Booking(){
        bookingID = "";
        customerId = "";
        hallId = "";
        purpose = "";

        attendance = 0;
        dateAndTime = "";
        catering = false;
        deposit = 0.0;
        totalPrice = 0.0;
        review = "";
    }

    public Booking(String BID, String CID, String HID, String purp, int atted, String dnt, boolean cat, double dp, double tp, String rw){
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

    public String getBookingID(){
        return bookingID;
    }

    public String getCustId(){
        return customerId;
    }

    public String getHallId(){
        return hallId;
    }

    public String getPurpose(){
        return purpose;
    }

    public int getAttendance(){
        return attendance;
    }

    public String DateandTime(){
        return dateAndTime;
    }

    public boolean getCater(){
        return catering;
    }

    public double getDeposit(){
        return deposit;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public String getReview(){
        return review;
    }

    public void setBookingID(String BID){
        bookingID = BID;
    }

    public void setCustomerId(String CID){
        customerId = CID;
    }

    public void setHallId(String HID){
        hallId = HID;
    }

    public void setPurpose(String purp){
        purpose = purp;
    }

    public void setAttendance(int atted){
        attendance = atted;
    }

    public void setDateAndTime(String dnt){
        dateAndTime = dnt;
    }

    public void setCater(boolean cat){
        catering = cat;
    }

    public void setDeposit(double dp){
        deposit = dp;
    }

    public void setTotalPrice(double tp){
        totalPrice = tp;
    }

    public void setReview(String rw) {
        review = rw;
    }

    public String toString(){
        String displayMessage = "";
        displayMessage += "BookingID: " + bookingID + "\n";
        displayMessage += "CustomerID: " + customerId + "\n";
        displayMessage += "HallID: " + hallId + "\n";
        displayMessage += "Purpose: " + customerId + "\n";
        displayMessage += "Attendance: " + attendance + "\n";
        displayMessage += "Date and Time: " + dateAndTime + "\n";
        displayMessage += "Catering: " + catering + "\n";
        displayMessage += "Deposit: " + deposit + "\n";
        displayMessage += "Total Price: " + totalPrice + "\n";
        displayMessage += "Review: " + review + "\n";

        return displayMessage;
    }
}
