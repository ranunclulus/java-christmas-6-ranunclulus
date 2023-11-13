package christmas.exception;

public enum ErrorCode {
    INVALID_STRING_INPUT("[ERROR] 숫자로 다시 입력해 주세요."),
    INVALID_DAY_INPUT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
