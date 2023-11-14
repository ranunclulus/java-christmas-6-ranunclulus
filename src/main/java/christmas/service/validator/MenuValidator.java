package christmas.service.validator;

import christmas.domain.Order;
import christmas.domain.constants.Menu;
import christmas.exception.ErrorCode;

import java.util.List;

public class MenuValidator {
    public static void existedMenu(String orderMenu) {
        for (Menu menu : Menu.values()) {
            if (orderMenu.equals(menu.getMenu())) return;
        }
        throw new IllegalArgumentException(ErrorCode.INVALID_ORDER_FORM.getMessage());
    }

    public static String getPresentMenu() {
        for (Menu menu : Menu.values()) {
            if (menu.isPresented()) {
                return menu.getMenu();
            }
        }
        throw new IllegalArgumentException(ErrorCode.INVALID_PRESENTED_MENU.getMessage());
    }

    public static int getPresentPrice() {
        for (Menu menu : Menu.values()) {
            if (menu.isPresented()) {
                return menu.getPrice();
            }
        }
        throw new IllegalArgumentException(ErrorCode.INVALID_PRESENTED_MENU.getMessage());
    }
}
