package org.example.food.truck.core.exception;

import lombok.experimental.Delegate;

/**
 * SystemErrorEnum
 *
 * @author chensheng
 */
public enum SystemErrorEnum implements ApplicationThrowable {
    INTERNAL_ERROR("10001", "服务器内部错误"),
    UNDEFINED_ERROR("10002", "%s"),
    NETWORK_REQUEST_ERROR("10003", "网络繁忙，请稍后重试"),
    INVALID_ENUM_TYPE("10004", "非法的枚举类型"),
    INVALID_ENUM_CODE("10005", "非法的枚举值"),
    SQL_EXCEPTION("10006", "数据库服务错误"),
    DATA_ACCESS_EXCEPTION("10007", "数据访问错误");

    private static final String TYPE = "SystemError";

    @Delegate
    private final ErrorEnumWrapper errorEnumWrapper;

    SystemErrorEnum(final String code, final String message) {
        errorEnumWrapper = ErrorEnumWrapper.of(code, message, TYPE);
    }
}
