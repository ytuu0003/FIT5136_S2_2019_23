/**
 * This Concession Class represents a concession object in the system.
 * It used to generate a concession object.
 *
 * @author XuShan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Concession {
    private String typeOfConcession;
    private double percent;

    /**
     * Creates a concession with default values on the type of concession  and percent
     *
     * */
    public Concession(){
        typeOfConcession = "";
        percent = 0.0;
    }

    /**
     * Creates a concession with new type of concession and new percent
     *
     * @param toc the type of concession which is assigned this concession
     * @param pr the percent of this concession
     * */
    public Concession(String toc, double pr){
        typeOfConcession = toc;
        percent = pr;
    }

    /**
     * Gets the type of concession
     *
     * @return A String object which contains the type of concession
     */
    public String getTypeOfConcession(){
        return typeOfConcession;
    }

    /**
     * Gets the percent of a concession
     *
     * @return A double value which is the percent of this concession.
     */
    public double getPercent(){
        return percent;
    }

    /**
     * Sets thethe type of concession
     *
     * @param  toc  the type of concession.
     */
    public void setTypeOfConcession(String toc){
        typeOfConcession = toc;
    }

    /**
     * Sets the percent of a concession
     *
     * @param  pr  the percent of this concession.
     */
    public void setPercent(double pr){
        percent = pr;
    }

    /**
     * Returns a string information of a particular concession
     *
     * @return  A String object that contains the concession details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(typeOfConcession);
        dm.append(",");
        dm.append(percent);
        return dm.toString();
    }
}
