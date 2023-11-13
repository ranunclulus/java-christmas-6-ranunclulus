package christmas.convertor;

import christmas.domain.Order;
import christmas.domain.OrderSheet;

import java.util.HashMap;
import java.util.Map;

public class OrderSheetConvertor {
    public static Map<String, Integer> convertToMap(OrderSheet orderSheet) {
        Map<String, Integer> orders = new HashMap<>();
        for (Order order : orderSheet.getOrders()) {
            orders.put(order.getMenuName(), order.getCount());
        }
        return orders;
    }
}
