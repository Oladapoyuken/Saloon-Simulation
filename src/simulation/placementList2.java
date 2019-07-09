
package simulation;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Yuken4real
 */
public class placementList2 {
    private SimpleStringProperty one, two, three, four, five, six, seven;

    public placementList2(String one, String two, String three, String four, String five, String six, String seven) {
        this.one = new SimpleStringProperty(one);
        this.two = new SimpleStringProperty(two);
        this.three = new SimpleStringProperty(three);
        this.four = new SimpleStringProperty(four);
        this.five = new SimpleStringProperty(five);
        this.six = new SimpleStringProperty(six);
        this.seven = new SimpleStringProperty(seven);
    }
    
    public String getOne() {
        return one.get();
    }

    public void setOne(SimpleStringProperty one) {
        this.one = one;
    }

    public String getTwo() {
        return two.get();
    }

    public void setTwo(SimpleStringProperty two) {
        this.two = two;
    }

    public String getThree() {
        return three.get();
    }

    public void setThree(SimpleStringProperty three) {
        this.three = three;
    }
    
    public String getFour() {
        return four.get();
    }

    public void setFour(SimpleStringProperty four) {
        this.four = four;
    }

    public String getFive() {
        return five.get();
    }
    public void setFive(SimpleStringProperty five) {
        this.five = five;
    }

    public String getSix() {
        return six.get();
    }

    public void setSix(SimpleStringProperty six) {
        this.six = six;
    }
    
    public String getSeven() {
        return seven.get();
    }

    public void setSeven(SimpleStringProperty seven) {
        this.seven = seven;
    }
    
    
    
}
