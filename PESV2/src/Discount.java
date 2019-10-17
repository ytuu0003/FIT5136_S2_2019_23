public class Discount {
        private String propertyName;
        private double percent;

        public Discount(){
            propertyName = "";
            percent = 0.0;
        }

        public Discount(String pn, double pr){
            propertyName = pn;
            percent = pr;
        }

        public String getPropertyName(){
            return propertyName;
        }

        public double getPercent(){
            return percent;
        }

        public void setPropertyName(String pn){
            propertyName = pn;
        }

        public void setName(double pr){
            percent = pr;
        }

        public String toStringItem(){
            StringBuffer dm = new StringBuffer();
            dm.append(propertyName);
            dm.append(",");
            dm.append(percent);
            return dm.toString();
        }
}
