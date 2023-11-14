package christmas.domain;

import christmas.service.Constant;

import java.util.Arrays;

public class Discount {
    private int totalDiscount;
    private int christmasDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int presentEvent;

    Discount() {
        this.totalDiscount = 0;
        this.christmasDiscount = 0;
        this.weekdayDiscount = 0;
        this.weekendDiscount = 0;
        this.specialDiscount = 0;
        this.presentEvent = 0;
    }

    public void isPresented(int price) {
        presentEvent = price;
    }

    public void calChristmas(int visitDay) {
        if (visitDay <= Constant.chiristmas) {
            int plusDiscount = Constant.defaultDiscount + 100 * (visitDay - 1);
            christmasDiscount += plusDiscount;
            totalDiscount += plusDiscount;
        }
    }

    public void calWeekday(int visitDay, int desertCnt) {
        int day = visitDay % 7;
        if (day != Constant.friday && day != Constant.saturday) {
            int plusDiscount = desertCnt * Constant.dayDiscount;
            weekdayDiscount += plusDiscount;
            totalDiscount += plusDiscount;
        }
    }

    public void calWeekend(int visitDay, int mainCnt) {
        int day = visitDay % 7;
        if (day == Constant.friday || day == Constant.saturday) {
            int plusDiscount = mainCnt * Constant.dayDiscount;
            weekendDiscount += plusDiscount;
            totalDiscount += plusDiscount;
        }
    }

    public void calSpecial(int visitDay) {
        boolean isSpecialDay = Arrays.stream(Constant.specialEventDay)
                .anyMatch(number -> number == visitDay);
        if (isSpecialDay) {
            specialDiscount += Constant.specialDiscountAmount;
            totalDiscount += Constant.specialDiscountAmount;
        }
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getPresentEvent() {
        return presentEvent;
    }
}
