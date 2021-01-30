package utils;

import java.math.BigDecimal;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Moneys {

    public static BigDecimal $(String value) {
        return new BigDecimal(value);
    }

    public static BigDecimal $(double value) {
        return new BigDecimal(value);
    }

    public static BigDecimal $(long value) {
        return new BigDecimal(value);
    }
}
