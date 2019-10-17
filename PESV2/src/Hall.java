//public class Hall {
//    private String hallName;
//    private String desc;
//    private String fullAddress;
//    private String contact;
//    public boolean caterService;
//    private String photoLink;
//    private int capacity;
//
//    public Hall(){
//        hallName = "";
//        desc = "";
//        fullAddress = "";
//        contact = "";
//        caterService = false;
//        photoLink = "";
//        capacity = 0;
//    }
//
//    public Hall(String newName, String newDesc, String newAddress, String newContact, boolean newCater, String newPhLink, int newCapacity){
//        hallName = newName;
//        desc = newDesc;
//        fullAddress = newAddress;
//        contact = newContact;
//        caterService = newCater;
//        photoLink = newPhLink;
//        capacity = newCapacity;
//    }
//
//    public String getName(){
//        return hallName;
//    }
//
//    public String getDesc(){
//        return desc;
//    }
//
//    public String getAddress(){
//        return fullAddress;
//    }
//
//    public String getContact(){
//        return contact;
//    }
//
//    public String getPhotoLink(){
//        return photoLink;
//    }
//
//    public int getCapacity(){
//        return capacity;
//    }
//
//    public boolean isCaterService() {
//        return caterService;
//    }
//
//    public void setName(String newName){
//        hallName = newName;
//    }
//
//    public void setDesc(String newDesc){
//        desc = newDesc;
//    }
//
//    public void setAddress(String newAddress){
//        fullAddress = newAddress;
//    }
//
//    public void setPhotoLink(String newPhLink){
//        photoLink = newPhLink;
//    }
//
//    public void setCatering(boolean newCater){
//        caterService = newCater;
//    }
//    public void setCapacity(int newCapacity){
//        capacity = newCapacity;
//    }
//
//    public String toString(){
//        String information = "\nHall Name: " + hallName + "\nDescription: " + desc
//                + "\nAddress: " + fullAddress + "\nContact Info: " + contact + "\nCatering Provided: "
//                + caterService + "\nPhoto Link: " + photoLink + "\nCapacity: " + capacity;
//        return information;
//    }
//}

import com.sun.jdi.PrimitiveValue;

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

    public String getFullAddress() {
        return fullAddress;
    }

    public String getHallName() {
        return hallName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public boolean isCaterService() {
        return caterService;
    }

    public String getTypeOfOccasion() {
        return typeOfOccasion;
    }

    public void setCaterService(boolean caterService) {
        this.caterService = caterService;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setTypeOfOccasion(String typeOfOccasion) {
        this.typeOfOccasion = typeOfOccasion;
    }

    public String getHallID(){
        return hallID;
    }

    public String getName(){
        return hallName;
    }

    public String getDesc(){
        return desc;
    }

    public String getAddress(){
        return fullAddress;
    }

    public String getContact(){
        return contact;
    }

    public String getPhotoLink(){
        return photoLink;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getPrice(){
        return price;
    }

    public void setHallID(String HID) {
        hallID = HID;
    }

    public void setName(String newName){
        hallName = newName;
    }

    public void setDesc(String newDesc){
        desc = newDesc;
    }

    public void setAddress(String newAddress){
        fullAddress = newAddress;
    }

    public void setPhotoLink(String newPhLink){
        photoLink = newPhLink;
    }

    public void setCatering(boolean newCater){
        caterService = newCater;
    }

    public void setCapacity(int newCapacity){
        capacity = newCapacity;
    }

    public void setPrice(double pr) {
        price = pr;
    }

    public String display(){
        String information = "\nHall Name: " + hallName + "\nDescription: " + desc
                + "\nAddress: " + fullAddress + "\nContact Info: " + contact + "\nCatering Provided: "
                + caterService + "\nPhoto Link: " + photoLink + "\nCapacity: " + capacity;
        return information;

    }
        public String toString(){
        String information = "\nHall Name: " + hallName + "\nDescription: " + desc
                + "\nAddress: " + fullAddress + "\nContact Info: " + contact + "\nCatering Provided: "
                + caterService + "\nPhoto Link: " + photoLink + "\nCapacity: " + capacity;
        return information;
    }

    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(hallID);
        dm.append(",");
        dm.append(ownerId);
        dm.append(",");
        dm.append(hallName);
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