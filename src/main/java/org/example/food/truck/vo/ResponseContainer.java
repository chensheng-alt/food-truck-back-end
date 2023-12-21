package org.example.food.truck.vo;

import org.apache.commons.lang3.StringUtils;
import org.example.food.truck.core.exception.ApplicationException;
import org.example.food.truck.core.exception.ApplicationThrowable;
import org.example.food.truck.core.exception.SystemErrorEnum;
import org.example.food.truck.util.HeaderUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ResponseContainer
 *
 * @author chensheng
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseContainer<T> {
    private static final long serialVersionUID = -4398321218789489583L;
    @ApiModelProperty("响应结果代码，200表示成功")
    private String resultCode;
    @ApiModelProperty("响应结果内容")
    private String message;
    @ApiModelProperty("异常ID")
    private String errorId;
    @ApiModelProperty("请求ID")
    private String transactionId;
    @ApiModelProperty("响应的数据")
    private T data;
    @ApiModelProperty("响应时间戳")
    private Long serverTime;

    public static <T> ResponseContainer<T> success() {
        return success(null);
    }

    public static <T> ResponseContainer<T> success(T data) {
        ResponseContainer<T> result = new ResponseContainer();
        result.setTransactionId(HeaderUtil.getTransactionId());
        result.setResultCode("200");
        result.setMessage("SUCCESS");
        result.setData(data);
        result.setServerTime(System.currentTimeMillis());
        return result;
    }

    public static <T> ResponseContainer<T> error(String errorId, ApplicationThrowable ex) {
        return error(ex.getErrorCode(), errorId, ex.getMessage());
    }

    public static <T> ResponseContainer<T> error(String errorId, String errorMsg) {
        return error(SystemErrorEnum.UNDEFINED_ERROR.getErrorCode(), errorId, errorMsg);
    }

    public static <T> ResponseContainer<T> error(ApplicationException ex) {
        return error(ex.getErrorCode(), ex.getErrorId(), ex.getMessage());
    }

    public static <T> ResponseContainer<T> error(String code, String errorId, String errorMsg) {
        return error(code, errorId, errorMsg, null);
    }

    public static <T> ResponseContainer<T> error(String errorCode, String errorId, String errorMsg, T data) {
        ResponseContainer<T> result = new ResponseContainer();
        result.setTransactionId(HeaderUtil.getTransactionId());
        result.setResultCode(StringUtils.isBlank(errorCode) ? SystemErrorEnum.INTERNAL_ERROR.getErrorCode() : errorCode);
        result.setMessage(StringUtils.isBlank(errorMsg) ? ApplicationException.getI18nMessage(
                SystemErrorEnum.INTERNAL_ERROR, new Object[0]) : errorMsg);
        result.setErrorId(errorId);
        result.setData(data);
        result.setServerTime(System.currentTimeMillis());
        return result;
    }

    public static <T> ResponseContainer<T> normalize(T resp) {
        String errorCode;
        String message;
        if (resp != null) {
            if (!ResponseBase.class.isAssignableFrom(resp.getClass())) {
                return success(resp);
            }

            ResponseBase responseBase = (ResponseBase) resp;
            if (responseBase.getCode() == null) {
                return success(resp);
            }

            errorCode = responseBase.getType();
            message = responseBase.getMessage();
        } else {
            errorCode = SystemErrorEnum.INTERNAL_ERROR.getErrorCode();
            message = ApplicationException.getI18nMessage(SystemErrorEnum.INTERNAL_ERROR, new Object[0]);
        }

        return error(errorCode, "DHjtyG5tVGpaBd9vycGL1b", message);
    }
}
