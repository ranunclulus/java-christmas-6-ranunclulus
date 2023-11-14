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
        System.out.println();
    }

    public static void printOrder(Map<String, Integer> orders) {
        System.out.println(Constant.ORDER_MENU);
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.printf(Constant.ORDER_MENU_FORM, entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void isPresented(String presentMenu) {
        System.out.println(Constant.PRESENTED);
        System.out.printf(Constant.ORDER_MENU_FORM, presentMenu, christmas.service.Constant.presentCnt);
        System.out.println();
    }

    public static void isNotPresented() {
        System.out.println(Constant.PRESENTED);
        System.out.println(Constant.NOT);
        System.out.println();
    }

    public static void isNotDiscounted() {
        System.out.println(Constant.DISCOUNT);
        System.out.println(Constant.NOT);
        System.out.println();
    }

    public static void printDiscount(Map<String, String> discountResult) {
        System.out.println(Constant.DISCOUNT);
        for (Map.Entry<String, String> entry : discountResult.entrySet()) {
            System.out.printf(Constant.DISCOUNT_FORM, entry.getKey(), entry.getValue());
        }
        System.out.println();
    }


    public static void totalDiscount(int totalDiscount) {
        System.out.println(Constant.TOTAL_DISCOUNT);
        System.out.printf(Constant.AMOUNT_FORM, OutputConvertor.toPrice(-totalDiscount));
        System.out.println();
    }

    public static void printAfter(int finalAmount) {
        System.out.println(Constant.AFTER_DISCOUNT);
        System.out.printf(Constant.AMOUNT_FORM, OutputConvertor.toPrice(finalAmount));
        System.out.println();
    }

    public static void printBadge(String badge) {
        System.out.println(Constant.BADGE);
        System.out.println(badge);
    }

    public static void printNoBadge() {
        System.out.println(Constant.BADGE);
        System.out.println(Constant.NOT);
    }
}
