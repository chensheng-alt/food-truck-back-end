package org.example.food.truck.vo;

import org.apache.commons.lang3.StringUtils;
import org.example.food.truck.core.exception.ApplicationException;
import org.example.food.truck.core.exception.SystemErrorEnum;
import lombok.Data;

/**
 * ResponseBase
 *
 * @author chensheng
 **/
@Data
public class ResponseBase {
    public static final String DEFAULT_ERROR_CODE = "500";
    private String code;
    private String type;
    private String message;

    public static ResponseBase error(ApplicationException ex) {
        return error(ex.getErrorCode(), ex.getMessage());
    }

    public static ResponseBase error(String errorCode, String errorMsg) {
        ResponseBase result = new ResponseBase();
        result.setCode("500");
        result.setType(StringUtils.isBlank(errorCode) ? SystemErrorEnum.INTERNAL_ERROR.getErrorCode() : errorCode);
        result.setMessage(StringUtils.isBlank(errorMsg) ? ApplicationException.getI18nMessage(
                SystemErrorEnum.INTERNAL_ERROR, new Object[0]) : errorMsg);
        return result;
    }
}

