package shampoo;

import label.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BasicShampoo {
    private static final String BRAND = "Fifty Shades";

    private static final BigDecimal PRICE = new BigDecimal("6.69");

    private static final Size SIZE = Size.SMALL;

    public FiftyShades() {}
    public FiftyShades(BasicLabel classicLabel) {
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
