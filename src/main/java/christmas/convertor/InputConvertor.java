package christmas.convertor;

import christmas.domain.Order;
import christmas.service.validator.MenuValidator;
import christmas.view.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputConvertor {
    public static int requireVisitDay(String visitDay) {
        try {
            InputValidator.dayIsDigit(visitDay);
            InputValidator.visitDayCheck(visitDay);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(error.getMessage());
        }

        return Integer.parseInt(visitDay);
    }
}
