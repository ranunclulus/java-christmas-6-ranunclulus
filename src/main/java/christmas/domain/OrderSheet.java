package christmas.domain;

import christmas.domain.constants.Menu;
import christmas.domain.constants.MenuType;
import christmas.exception.ErrorCode;
import christmas.service.Constant;
import christmas.service.validator.MenuValidator;
import christmas.view.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class OrderSheet {
    private int visitDay;
    private List<Order> orders;
    private int totalOrderCnt;
    private int totalAmount;
    private boolean isPresented;
    private Discount discount;

    public OrderSheet(int visitDay) {
        this.visitDay = visitDay;
        this.orders = new ArrayList<>();
        this.totalOrderCnt = 0;
        this.totalAmount = 0;
        this.isPresented = false;
        this.discount = new Discount();
    }

    public void addOrder(String rawOrder) {
        String[] orderSheets = rawOrder.split(",");

        for (String orderSheet : orderSheets) {
            String[] orderContent = orderSheet.split("-");

            try {
                InputValidator.isOrdered(orderContent);

                String menu = orderContent[0].trim();
                String count = orderContent[1].trim();

                MenuValidator.existedMenu(menu);
                InputValidator.orderIsDigit(count);
                InputValidator.minOrder(count);
                alreadyOrder(menu);
                underTotalCnt(Integer.parseInt(count));

                Order order = new Order(menu, Integer.parseInt(count));
                orders.add(order);
                addOrderCount(order.getCount());
            } catch (IllegalArgumentException error) {
                throw new IllegalArgumentException(error.getMessage());
            }
        }
    }

    private void addOrderCount(int count) {
        this.totalOrderCnt += count;
    }

    private void alreadyOrder(String orderName) {
        for (Order order : orders) {
            if (orderName.equals(order.getMenuName())) {
                throw new IllegalArgumentException(ErrorCode.INVALID_ORDER_FORM.getMessage());
            }
        }
    }

    private void underTotalCnt(int count) {
        if (totalOrderCnt + count > Constant.maxOrder) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ORDER_FORM.getMessage());
        }
    }

    public void regularPrice() {
        for (Order order : orders) {
            String menuName = order.getMenuName();
            int orderCount = order.getCount();

            for (Menu menu : Menu.values()) {
                if (menuName.equals(menu.getMenu())) {
                    totalAmount += menu.getPrice() * orderCount;
                }
            }
        }
    }

    public void calPresented() {
        if (totalAmount >= Constant.presentationCondition) {
            isPresented = true;
            discount.isPresented(MenuValidator.getPresentPrice());
        }
    }

    public void calDiscount() {
        discount.calChristmas(visitDay);
        discount.calWeekday(visitDay, getDesertCount());
        discount.calWeekend(visitDay, getMainCount());
        discount.calSpecial(visitDay);
    }

    private int getMainCount() {
        return (int) orders.stream()
                .filter(order -> order.getMenuType() == MenuType.MAIN)
                .mapToInt(Order::getCount)
                .sum();
    }

    private int getDesertCount() {
        return (int) orders.stream()
                .filter(order -> order.getMenuType() == MenuType.DESERT)
                .mapToInt(Order::getCount)
                .sum();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public boolean getIsPresented() { return isPresented; }

    public boolean isDiscounted() {
        return discount.getTotalDiscount() != 0;
    }

    public Discount getDiscount() { return discount; }

    public int getFinalAmount() {
        return totalAmount - (discount.getTotalDiscount() - discount.getPresentEvent());
    }
}
