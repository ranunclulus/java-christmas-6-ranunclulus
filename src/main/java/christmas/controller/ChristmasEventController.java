package christmas.controller;

import christmas.convertor.DiscountConvertor;
import christmas.convertor.InputConvertor;
import christmas.convertor.OrderSheetConvertor;
import christmas.domain.OrderSheet;
import christmas.service.validator.MenuValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasEventController {
    public void run() {
        OutputView.printOnboarding();
        int visitDay = setVisitDay();
        OrderSheet orderSheet = new OrderSheet(visitDay);

        orderMenu(orderSheet);
        OutputView.printEventIntro();
        OutputView.printOrder(OrderSheetConvertor.convertToMap(orderSheet));
        orderSheet.regularPrice();
        OutputView.printBefore(orderSheet.getTotalAmount());
        presentEvent(orderSheet);
        discount(orderSheet);
        OutputView.totalDiscount(orderSheet.getDiscount().getTotalDiscount());
        OutputView.printAfter(orderSheet.getFinalAmount());
        giveBadge(orderSheet);
    }

    private void giveBadge(OrderSheet orderSheet) {
        if (orderSheet.getDiscount().haveBadge()) {
            orderSheet.getDiscount().calBadge();
            OutputView.printBadge(orderSheet.getDiscount().getBadge());
        }
        if (!orderSheet.getDiscount().haveBadge()) {
            OutputView.printNoBadge();
        }
    }

    private void orderMenu(OrderSheet orderSheet) {
        try {
            orderSheet.addOrder(InputView.requireOrder());
        } catch (IllegalArgumentException error) {
            OutputView.printError(error.getMessage());
            orderMenu(orderSheet);
        }
    }

    private int setVisitDay() {
        try {
            int visitDay = InputConvertor.requireVisitDay(InputView.requireVisitDay());
            return visitDay;
        } catch (IllegalArgumentException error) {
            OutputView.printError(error.getMessage());
            setVisitDay();
        }
        return 0;
    }

    private void presentEvent(OrderSheet orderSheet) {
        orderSheet.calPresented();
        if (orderSheet.getIsPresented()) {
            OutputView.isPresented(MenuValidator.getPresentMenu());
        }
        if (!orderSheet.getIsPresented()) {
            OutputView.isNotPresented();
        }
    }

    private void discount(OrderSheet orderSheet) {
        orderSheet.calDiscount();
        if (orderSheet.isDiscounted()) {
            OutputView.printDiscount(DiscountConvertor.convertToMap(orderSheet.getDiscount()));
        }
        if (!orderSheet.isDiscounted()) {
            OutputView.isNotDiscounted();
        }
    }
}
