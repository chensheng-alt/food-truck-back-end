package org.example.food.truck.core.exception;

import lombok.experimental.Delegate;

/**
 * BusinessErrorEnum
 *
 * @author chensheng
 */
public enum BusinessErrorEnum implements ApplicationThrowable {
    ILLEGAL_PARAMETER("10051", "[参数错误]%s"),
    DUPLICATE_KEY("10052", "违反业务唯一性限制"),
    FLOW_LIMIT("10053", "系统繁忙，请稍后重试"),
    UPDATE_FAILED_OPTIMISTIC_LOCK("10054", "您的数据已经发生变化，请刷新重试"),
    DATA_NOT_EXISTS("10055", "数据不存在");
    private static final String TYPE = "BusinessError";

    @Delegate
    private final ErrorEnumWrapper errorEnumWrapper;

    BusinessErrorEnum(final String code, final String message) {
        errorEnumWrapper = ErrorEnumWrapper.of(code, message, TYPE);
    }
}
