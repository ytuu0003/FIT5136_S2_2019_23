import com.sun.jdi.PrimitiveValue;
/**
 * This Hall Class represents a hall object in the system.
 * It used to generate a hall object.
 *
 * @author Yushan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Hall {
    private String hallID;
    private String ownerId;
    private String hallName;
    private String desc;
    private String fullAddress;
    private String contact;
    private String typeOfOccasion;
    private boolean caterService;
    private String photoLink;
    private int capacity;
    private double price;

    /**
     * Creates a hall with default values on hall id, hall name, owner id, description, full address, contact,
     * type of occasion, catering service, photoLink, capacity and price.
     *
     * */
    public Hall(){
        hallID = "";
        hallName = "";
        ownerId = "";
        desc = "";
        fullAddress = "";
        contact = "";
        typeOfOccasion = "";
        caterService = false;
        photoLink = "";
        capacity = 0;
        price = 0.0;
    }

    /**
     * Creates a hall with hall id, hall name, owner id, description, full address, contact,
     * type of occasion, catering service, photoLink, capacity and price.
     *
     * @param  HID The id of a hall.
     * @param  newName The name of a hall.
     * @param  OID The owner id of this hall.
     * @param  newDesc The description of this hall.
     * @param  newAddress The address of this hall.
     * @param  newContact The contact information of this hall.
     * @param  TOC The type of accasion provided by this hall.
     * @param  newCater The catering service provided by this hall.
     * @param  newPhLink  The photo link of this hall.
     * @param  pr The estimate price of this hall.
     * */
    public Hall(String HID, String newName, String OID, String newDesc, String newAddress, String newContact, String TOC, boolean newCater, String newPhLink, int newCapacity, double pr){
        hallID = HID;
        hallName = newName;
        ownerId = OID;
        desc = newDesc;
        fullAddress = newAddress;
        contact = newContact;
        typeOfOccasion = TOC;
        caterService = newCater;
        photoLink = newPhLink;
        capacity = newCapacity;
        price = pr;
    }

    /**
     * Returns a string information of a particular hall for display
     *
     * @return  A String object that contains the hall details information.
     * */
    public String display(){
        String information = "\nHall Name: " + hallName + "\nDescription: " + desc
                + "\nAddress: " + fullAddress + "\nContact Info: " + contact + "\nCatering Provided: "
                + caterService + "\nPhoto Link: " + photoLink + "\nCapacity: " + capacity;
        return information;

    }

    /**
     * Gets the address of a hall
     *
     * @return The String object that contains the address of the hall
     * */
    public String getAddress(){
        return fullAddress;
    }

    /**
     * Sets the address of this hall.
     *
     * @param newAddress the address of this hall
     * */
    public void setAddress(String newAddress){
        fullAddress = newAddress;
    }

    /**
     * Gets the capacity of this hall
     *
     * @return A String object which contains the capacity of this hall.
     * */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Sets the capacity of this hall.
     *
     * @param newCapacity the capacity of this hall
     * */
    public void setCapacity(int newCapacity){
        capacity = newCapacity;
    }

    /**
     * Gets the contact information of a user who owns this hall
     *
     * @return The String object that contains the contact information of a user who owns this hall
     * */
    public String getContact(){
        return contact;
    }

    /**
     * Sets the contact information which belongs to owner which has this hall.
     *
     * @param contact the contact information which belongs to owner which has this hall.
     * */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the description of a hall
     *
     * @return A String object which contains the hall description information.
     * */
    public String getDesc(){
        return desc;
    }

    /**
     * Sets the description of this hall.
     *
     * @param newDesc the description of this hall
     * */
    public void setDesc(String newDesc){
        desc = newDesc;
    }

    /**
     * Gets the id of hall
     *
     * @return A String object which contains the hall id information.
     * */
    public String getHallID(){
        return hallID;
    }

    /**
     * Sets the id of this hall.
     *
     * @param HID the id of this hall
     * */
    public void setHallID(String HID) {
        hallID = HID;
    }

    /**
     * Gets the name of a hall
     *
     * @return The String object that contains the name of the hall
     * */
    public String getName(){
        return hallName;
    }

    /**
     * Sets the name of this hall.
     *
     * @param newName the name of this hall
     * */
    public void setName(String newName){
        hallName = newName;
    }

    /**
     * Gets the owner id who this hall belongs
     *
     * @return The String object that contains the owner id who this hall belongs
     * */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the owner id which has this hall.
     *
     * @param ownerId the owner id information
     * */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the photo link of this hall
     *
     * @return The String object that contains the photo link of this hall
     * */
    public String getPhotoLink(){
        return photoLink;
    }

    /**
     * Sets the photo link of this hall.
     *
     * @param newPhLink the photo link of this hall
     * */
    public void setPhotoLink(String newPhLink){
        photoLink = newPhLink;
    }

    /**
     * Gets the price of this hall
     *
     * @return A double value which contains the price information.
     * */
    public double getPrice(){
        return price;
    }

    /**
     * Sets the price of this hall.
     *
     * @param pr the price of this hall
     * */
    public void setPrice(double pr) {
        price = pr;
    }

    /**
     * Gets the type of occasion provided by this hall.
     *
     * @return A String object which contains the type of occasion provided by this hall.
     * */
    public String getTypeOfOccasion() {
        return typeOfOccasion;
    }

    /**
     * Sets the type of occasion provided by this hall.
     *
     * @param typeOfOccasion the type of occasion provided by this hall.
     * */
    public void setTypeOfOccasion(String typeOfOccasion) {
        this.typeOfOccasion = typeOfOccasion;
    }

    /**
     * Gets the catering service of this hall
     *
     * @return A boolean value which contains the catering service information.
     * */
    public boolean isCaterService() {
        return caterService;
    }

    /**
     * Sets the catering service of this hall.
     *
     * @param newCater the catering service of this hall
     * */
    public void setCatering(boolean newCater){
        caterService = newCater;
    }

    /**
     * Returns a string information of a particular hall for display
     *
     * @return  A String object that contains the hall details information.
     * */
    public String toString(){
        String information = "\nHall Name: " + hallName + "\nDescription: " + desc
                + "\nAddress: " + fullAddress + "\nContact Info: " + contact + "\nCatering Provided: "
                + caterService + "\nPhoto Link: " + photoLink + "\nCapacity: " + capacity;
        return information;
    }

    /**
     * Returns a string information of a particular hall for display in the database(file)
     *
     * @return  A String object that contains the hall details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(hallID);
        dm.append(",");
        dm.append(hallName );
        dm.append(",");
        dm.append(ownerId);
        dm.append(",");
        dm.append(desc);
        dm.append(",");
        dm.append(fullAddress);
        dm.append(",");
        dm.append(contact);
        dm.append(",");
        dm.append(typeOfOccasion);
        dm.append(",");
        dm.append(caterService);
        dm.append(",");
        dm.append(photoLink);
        dm.append(",");
        dm.append(capacity);
        dm.append(",");
        dm.append(price);
        return dm.toString();
    }
}