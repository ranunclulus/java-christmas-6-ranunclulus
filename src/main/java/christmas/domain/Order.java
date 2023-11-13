package christmas.domain;

import christmas.domain.constants.Menu;

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

    public int getCount() {
        return count;
    }
}
