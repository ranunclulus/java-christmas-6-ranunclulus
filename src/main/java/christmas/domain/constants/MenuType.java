package christmas.domain.constants;

public enum MenuType {
    APPETIZER("Appetizer"),
    MAIN("Main"),
    DESERT("Desert"),
    DRINK("Drink");

    private String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }
}
