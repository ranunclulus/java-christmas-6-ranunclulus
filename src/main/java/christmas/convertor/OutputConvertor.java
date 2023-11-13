package christmas.convertor;

import java.text.DecimalFormat;

public class OutputConvertor {
    public static String toPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }
}
