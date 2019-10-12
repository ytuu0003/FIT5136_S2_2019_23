public class Hall {
    private String hallName;
    private String desc;
    private String fullAddress;
    private String contact;
    private boolean caterService;
    private String photoLink;
    private int capacity;

    public Hall(){
        hallName = "";
        desc = "";
        fullAddress = "";
        contact = "";
        caterService = false;
        photoLink = "";
        capacity = 0;
    }

    public Hall(String newName, String newDesc, String newAddress, String newContact, boolean newCater, String newPhLink, int newCapacity){
        hallName = newName;
        desc = newDesc;
        fullAddress = newAddress;
        contact = newContact;
        caterService = newCater;
        photoLink = newPhLink;
        capacity = newCapacity;
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

    public String display(){
        String information = "\nHall Name: " + hallName + "\nDescription: " + desc
                + "\nAddress: " + fullAddress + "\nContact Info: " + contact + "\nCatering Provided: "
                + caterService + "\nPhoto Link: " + photoLink + "\nCapacity: " + capacity;
        return information;

    }
}