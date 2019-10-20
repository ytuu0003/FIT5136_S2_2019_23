/**
 * This Discount Class represents a discount object in the system.
 * It used to generate a discount object.
 *
 * @author XuShan Tu, Yaohan Li and Xinyue Huang
 * @version 1.0 (19 Oct 2019)
 * */
public class Discount {
    private String propertyName;
    private double percent;

    /**
     * Creates a discount with default values on the property name and percent
     *
     * */
    public Discount(){
        propertyName = "";
        percent = 0.0;
    }

    /**
     * Creates a discount with new property name and new percent
     *
     * @param pn the property name which is assigned this discount
     * @param pr the percent of this discount
     * */
    public Discount(String pn, double pr){
        propertyName = pn;
        percent = pr;
    }

    /**
     * Gets the property name of a discount
     *
     * @return A String object which contains the property name of a discount.
     */
    public String getPropertyName(){
        return propertyName;
    }

    /**
     * Gets the percent of a discount
     *
     * @return A double value which is the percent of this discount.
     */
    public double getPercent(){
        return percent;
    }

    /**
     * Sets the property name of a discount
     *
     * @param  pn  the property name of this discount.
     */
    public void setPropertyName(String pn){
        propertyName = pn;
    }

    /**
     * Sets the percent of a discount
     *
     * @param  pr  the percent of this discount.
     */
    public void setPercent(double pr){
        percent = pr;
    }

    /**
     * Returns a string information of a particular discount
     *
     * @return  A String object that contains the discount details information.
     * */
    public String toStringItem(){
        StringBuffer dm = new StringBuffer();
        dm.append(propertyName);
        dm.append(",");
        dm.append(percent);
        return dm.toString();
    }
}
