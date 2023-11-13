package christmas.convertor;

import christmas.exception.ErrorCode;
import christmas.service.validator.InputValidator;

public class InputConvertor {
    public static int requireVisitDay(String visitDay) {
        if (!InputValidator.isDigit(visitDay)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_STRING_INPUT.getMessage());
        }
        if (!InputValidator.visitDayCheck(visitDay)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DAY_INPUT.getMessage());
        }
        return Integer.parseInt(visitDay);
    }
}
