package christmas.convertor;

import christmas.domain.Discount;
import christmas.service.Constant;

import java.util.HashMap;
import java.util.Map;

public class DiscountConvertor {
    public static Map<String, String> convertToMap(Discount discount) {
        Map<String, String> discountResult = new HashMap<>();

        if (discount.getChristmasDiscount() != 0) {
            discountResult.put(
                    Constant.christmasDiscount,
                    OutputConvertor.toPrice(-discount.getChristmasDiscount()));
        }
        if (discount.getWeekdayDiscount() != 0) {
            discountResult.put(
                    Constant.weekdayDiscount,
                    OutputConvertor.toPrice(-discount.getWeekdayDiscount()));
        }
        if (discount.getWeekendDiscount() != 0) {
            discountResult.put(
                    Constant.weekendDiscount,
                    OutputConvertor.toPrice(-discount.getWeekendDiscount()));
        }
        if (discount.getSpecialDiscount() != 0) {
            discountResult.put(
                    Constant.specialDiscount,
                    OutputConvertor.toPrice(-discount.getSpecialDiscount()));
        }
        if (discount.getPresentEvent() != 0) {
            discountResult.put(
                    Constant.presentEvent,
                    OutputConvertor.toPrice(-discount.getPresentEvent()));
        }

        return discountResult;
    }
}
