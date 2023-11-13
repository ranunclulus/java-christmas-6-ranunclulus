package christmas.controller;

import christmas.convertor.InputConvertor;
import christmas.convertor.OrderSheetConvertor;
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

        // 할인 전 주문 금액 출력
        OutputView.printEventIntro();
        OutputView.printOrder(OrderSheetConvertor.convertToMap(orderSheet));
        OutputView.printBefore(orderSheet.regularPrice());

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
