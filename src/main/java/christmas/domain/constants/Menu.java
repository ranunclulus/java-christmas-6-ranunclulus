package christmas.domain.constants;

public enum Menu {
    BUTTON_MUSHROOM_SOUP(MenuType.APPETIZER, "양송이수프", 6000),
    TAPAS(MenuType.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(MenuType.APPETIZER, "시저샐러드", 8000),
    TBONE_STEAK(MenuType.MAIN, "티본스테이크", 55000),
    BARBECUE_RIBS(MenuType.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(MenuType.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MenuType.MAIN, "크리스마스파스타", 25000),
    CHOCO_CAKE(MenuType.DESERT, "초코케이크", 15000),
    ICECREAM(MenuType.DESERT, "아이스크림", 5000),
    ZERO_COKE(MenuType.DRINK, "제로콜라", 3000),
    RED_WINE(MenuType.DRINK, "레드와인", 60000),
    CHAMPAGNE(MenuType.DRINK, "샴페인", 25000);
    private MenuType menuType;
    private String menu;
    private int price;

    Menu(MenuType menuType, String menu, int price) {
        this.menuType = menuType;
        this.menu = menu;
        this.price = price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }
}
