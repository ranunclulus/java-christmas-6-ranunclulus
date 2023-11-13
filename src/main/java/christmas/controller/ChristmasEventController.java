package christmas.controller;

import christmas.convertor.InputConvertor;
import christmas.domain.OrderSheet;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasEventController {
    public void run() {
        // 방문 날짜 설정
        OutputView.printOnboarding();
        int visitDay = setVisitDay();
        OrderSheet orderSheet = new OrderSheet(visitDay);

        // 메뉴 주문
        orderMenu(orderSheet);

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
}
