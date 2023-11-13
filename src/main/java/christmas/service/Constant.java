package christmas.service;

import java.util.Map;

public class Constant {
    public static final Map<String, Integer> badge = Map.of(
            "별", 5000,
            "트리", 10000,
            "산타", 20000
    );

    public static final int[] specialEventDay = new int[] {3, 10, 17, 24, 25, 31};
    public static final int maxOrder = 20;
    public static final int minOrder = 1;
    public static final int startDay = 1;
    public static final int endDay = 31;
    public static final int presentationCondition = 120000;
    public static final int weekendStart = 2;
}
