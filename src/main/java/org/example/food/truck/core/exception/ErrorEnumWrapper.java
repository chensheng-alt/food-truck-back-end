package org.example.food.truck.core.exception;

/**
 * ErrorEnumWrapper
 *
 * @author chensheng
 **/
public class ErrorEnumWrapper implements ApplicationThrowable {
    private String errorCode;
    private String message;
    private String type;

    ErrorEnumWrapper(String code, String message, String type) {
        this.errorCode = code;
        this.message = message;
        this.type = type;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getType() {
        return this.type;
    }

    public static ErrorEnumWrapper of(String code, String message, String type) {
        return new ErrorEnumWrapper(code, message, type);
    }
}
