package shampoo;

import com.sun.org.glassfish.gmbal.Description;
import label.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {
    private static final String BRAND = "Pink Panther";

    private static final BigDecimal PRICE = new BigDecimal("8.50");

    private static final Size SIZE = Size.MEDIUM;

    public PinkPanther() {}
    public PinkPanther(BasicLabel classicLabel) {
        super(BRAND,PRICE,SIZE,classicLabel);
    }

    public static String getBRAND() {
        return BRAND;
    }

    public static BigDecimal getPRICE() {
        return PRICE;
    }

    public static Size getSIZE() {
        return SIZE;
    }

}
