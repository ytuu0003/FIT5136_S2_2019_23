public class Concession {
    private String typeOfConcession;
    private double percent;

    public Concession(){
        typeOfConcession = "";
        percent = 0.0;
    }

    public Concession(String toc, double pr){
        typeOfConcession = toc;
        percent = pr;
    }

    public String getTypeOfConcession(){
        return typeOfConcession;
    }

    public double getPercent(){
        return percent;
    }

    public void setTypeOfConcession(String toc){
        typeOfConcession = toc;
    }

    public void setName(double pr){
        percent = pr;
    }

    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(typeOfConcession);
        dm.append(",");
        dm.append(percent);
        return dm.toString();
    }
}
