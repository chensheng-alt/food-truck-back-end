package org.example.food.truck.core.exception;


import org.example.food.truck.core.util.MessageUtil;

/**
 * ApplicationException
 *
 * @author chensheng
 **/
public class ApplicationException extends RuntimeException implements ApplicationThrowable {
    private String errorCode;
    private String errorId;
    private String type;
    private static final String MESSAGE_PREFIX = "error.";

    public ApplicationException(String errorId, ApplicationThrowable errorEnum) {
        this(errorId, errorEnum, null);
    }

    public ApplicationException(String errorId, ApplicationThrowable errorEnum, Throwable cause) {
        this(errorId, errorEnum, cause, (Object[]) null);
    }

    public ApplicationException(String errorId, ApplicationThrowable errorEnum, Throwable cause, Object... args) {
        super(getI18nMessage(errorEnum, args), cause);
        this.errorId = errorId;
        this.errorCode = errorEnum.getErrorCode();
        this.type = this.getType(errorEnum);
    }

    public static String getI18nMessage(ApplicationThrowable errorEnum, Object... args) {
        return String.format(MessageUtil.getMessage(MESSAGE_PREFIX + errorEnum.getErrorCode(),
                new Object[0], errorEnum.getMessage()), args);
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public String getErrorId() {
        return this.errorId;
    }

    private String getType(ApplicationThrowable errorEnum) {
        return errorEnum != null ? errorEnum.getType() : "";
    }
}
