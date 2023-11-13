package christmas.view.validator;

import christmas.domain.constants.Menu;
import christmas.exception.ErrorCode;
import christmas.service.Constant;

public class InputValidator {


    public static void dayIsDigit(String visitDay) {
        try {
            int day = Integer.parseInt(visitDay);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DAY_INPUT.getMessage());
        }
    }

    public static void visitDayCheck(String visitDay) {
        int day = Integer.parseInt(visitDay);
        if (day < Constant.startDay || day > Constant.endDay) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DAY_INPUT.getMessage());
        }
    }


    public static void isOrdered(String[] orderContent) {
        if (orderContent.length != 2) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ORDER_FORM.getMessage());
        }
    }

    public static void minOrder(String count) {
        if (Integer.parseInt(count) <= 0)
            throw new IllegalArgumentException(ErrorCode.INVALID_ORDER_FORM.getMessage());
    }

    public static void orderIsDigit(String count) {
        try {
            int orderCount = Integer.parseInt(count);

        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ORDER_FORM.getMessage());
        }
    }
}
