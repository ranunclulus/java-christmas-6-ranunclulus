package christmas.service.validator;

import christmas.exception.ErrorCode;
import christmas.service.Constant;

public class InputValidator {


    public static boolean isDigit(String visitDay) {
        try {
            int day = Integer.parseInt(visitDay);
            return true;
        } catch (IllegalArgumentException error) {
            return false;
        }
    }

    public static boolean visitDayCheck(String visitDay) {
        int day = Integer.parseInt(visitDay);
        if (day < Constant.startDay || day > Constant.endDay) {
            return false;
        }
        return true;
    }
}
