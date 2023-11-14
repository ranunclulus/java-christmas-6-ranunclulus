package christmas.domain;

import christmas.domain.constants.Menu;
import christmas.domain.constants.MenuType;

public class Order {
    private Menu menu;
    private int count;

    public Order(String menuName, int count) {
        for(Menu menu : Menu.values()) {
            if (menuName.equals(menu.getMenu())) {
                this.menu = menu;
            }
        }
        this.count = count;
    }

    public String getMenuName() {
        return menu.getMenu();
    }

    public MenuType getMenuType() { return menu.getMenuType(); }

    public int getCount() {
        return count;
    }

}
