package christmas.domain;

import christmas.domain.constants.Menu;
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

    public OrderSheet(int visitDay) {
        this.visitDay = visitDay;
        this.orders = new ArrayList<>();
        this.totalOrderCnt = 0;
        this.totalAmount = 0;
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

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
