import java.lang.Math;

public class Quotation {
    private String quotationInfo;
    private double[] priceList = new double[3];
    private String ownerId;
    private String hallId;
    private String customerId;
    private int state;

    public Quotation(){
        quotationInfo = "";
        priceList = new double[]{0.0, 0.0, 0.0};
        ownerId = "";
        hallId = "";
        customerId = "";
        state = 0;
    }


    public String getQuotationInfo(){
        return quotationInfo;
    }

    public double getPriceList(int index){
        return priceList[index];
    }

    public int getState(){
        return state;
    }

    public String getHallId(){
        return hallId;
    }

    public String getCustomerId(){
        return customerId;
    }

    public String getOwnerId(){
        return ownerId;
    }

    public void setQuotationInfo(String newInfo){
        quotationInfo = newInfo;
    }

    public void setPriceList(double price, double discount){
        priceList[0] = price;
        priceList[1] = discount;
        priceList[2] = Math.round((price * (1 - discount) * 0.1) * 100.0) / 100.0;
    }

    public void setState(int newState){
        state = newState;
    }

    public String displayQuotationInfo(){
        String info = "";
        info = "Quotation Info: " + quotationInfo + "\nOwner ID: " + ownerId + "\nHall ID: " + hallId + "\nCustomer ID: "
                + customerId + "\nState: " + state;
        return info;
    }

    public String[] splitQuotationInfo(){
        return quotationInfo.split(",",6);
    }


//    Hall hall1 = new Hall("hall1","desc1","addr1","12323123",true,"wefaf.com",43);
//    Hall hall2 = new Hall("hall2","desc2","addr2","12323123",false,"wefaf.com",25);
//    public void testFile1(){
//        quotationInfo = "50,true,20191111,110.0,wedding,,990.0";
//        priceList = new double[]{.0, 0.0, 0.0};
//        setPriceList(500.0, 0.85);
//        ownerId = "201";
//        hallId = "10";
//        customerId = "101";
//        state = 1;
//    }
//
//    public void testFile2(){
//        quotationInfo = "100,false,20191201,120.0,wedding,,1010.0";
//        priceList = new double[]{.0, 0.0, 0.0};
//        setPriceList(500.0, 0.85);
//        ownerId = "202";
//        hallId = "10";
//        customerId = "101";
//        state = 0;
//    }
    public Quotation(String newQuotationInfo, double[] newPriceList, String newOwnerId, String newHallId, String newCustomerId, int newState){
        quotationInfo = newQuotationInfo;
        priceList = newPriceList;
        ownerId = newOwnerId;
        hallId = newHallId;
        customerId = newCustomerId;
        state = newState;
    }

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
