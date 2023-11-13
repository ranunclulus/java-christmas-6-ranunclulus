package christmas.controller;

import christmas.convertor.InputConvertor;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasEventController {
    public void run() {
        OutputView.printOnboarding();
        setVisitDay();

    }

    private void setVisitDay() {
        try {
            int visitDay = InputConvertor.requireVisitDay(InputView.requireVisitDay());
        } catch (IllegalArgumentException error) {
            OutputView.printError(error.getMessage());
            setVisitDay();
        }
    }
}
