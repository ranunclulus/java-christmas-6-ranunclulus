package christmas.domain.constants;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private String badeName;
    private int condition;

    Badge(String badeName, int condition) {
        this.badeName = badeName;
        this.condition = condition;
    }

    public String getBadeName() {
        return badeName;
    }

    public int getCondition() {
        return condition;
    }
}
