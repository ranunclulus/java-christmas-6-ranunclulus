package christmas.view;

import christmas.convertor.OutputConvertor;
import christmas.domain.OrderSheet;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    public static void printOnboarding() {
        System.out.println(Constant.ONBOARDING);
    }


    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printEventIntro() {
        System.out.println(Constant.EVENT_INTRO);
        System.out.println();
    }

    public static void printBefore(int price) {
        System.out.println(Constant.BEFORE_DISCOUNT);
        System.out.printf(Constant.AMOUNT_FORM, OutputConvertor.toPrice(price));
    }

    public static void printOrder(Map<String, Integer> orders) {
        System.out.println(Constant.BEFORE_DISCOUNT);
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.printf(Constant.ORDER_MENU_FORM, entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
