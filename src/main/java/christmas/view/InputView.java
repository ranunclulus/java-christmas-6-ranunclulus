package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String requireVisitDay() {
        System.out.println(Constant.ASK_VISIT_DAY);
        return Console.readLine();
    }

    public static String requireOrder() {
        System.out.println(Constant.ASK_ORDER);
        return Console.readLine();
    }

}
