package christmas.exception;

public enum ErrorCode {
    INVALID_DAY_INPUT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORM("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_PRESENTED_MENU("[ERROR] 증정품으로 지정된 메뉴가 없습니다.");
    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
