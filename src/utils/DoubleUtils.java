package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class DoubleUtils {

    public static boolean equalTo(double v1, double v2, int precision) {
        return toPrecision(v1, 3) == toPrecision(v2, precision);
    }

    public static double toPrecision(double value, int precision) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }


}
