package christmas.exception;

public enum ErrorCode {
    INVALID_DAY_INPUT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORM("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
