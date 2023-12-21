package org.example.food.truck.handler;

import org.example.food.truck.core.exception.ApplicationException;
import org.example.food.truck.core.exception.BusinessErrorEnum;
import org.example.food.truck.core.exception.SystemErrorEnum;
import org.example.food.truck.core.util.ExceptionUtil;
import org.example.food.truck.core.util.MessageUtil;
import org.example.food.truck.util.HeaderUtil;
import org.example.food.truck.vo.ResponseContainer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.util.NestedServletException;

import java.sql.SQLException;
import java.util.Objects;

/**
 * GlobalExceptionHandler
 *
 * @author chensheng
 **/
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    public static final String FEIGN = "feign.";
    public static final String RIBBON = "com.netflix.client.";

    private String getMessage(String key, Object[] args, String defaultValue) {
        return MessageUtil.getMessage(key, args, defaultValue);
    }

    private String getMessage(Exception e, Object[] args) {
        return this.getMessage(e.getClass(), args);
    }

    private String getMessage(Class<? extends Exception> clz, Object[] args) {
        String name = "GlobalExceptionHandler." + clz.getSimpleName();
        return this.getMessage(name, args, "HTTP请求参数不合法");
    }

    @ExceptionHandler({Throwable.class})
    public ResponseContainer<Void> handleException(Throwable ex) {
        if (StringUtils.startsWith(ex.getClass().getName(), FEIGN)) {
            return this.handleApplicationException(
                    SystemErrorEnum.NETWORK_REQUEST_ERROR.wrapException("4yiyaWuRQVPMcVgSo1HiAB", ex, new Object[0]));
        } else {
            return null != ex.getCause() && null != ex.getCause().getClass() && StringUtils.startsWith(ex.getCause().getClass().getName(), "com.netflix.client.") ? this.handleApplicationException(SystemErrorEnum.NETWORK_REQUEST_ERROR.wrapException("UN59tnmiMw7XA9NhogD7U9", ex, new Object[0])) : this.handleApplicationException(SystemErrorEnum.INTERNAL_ERROR.wrapException("QXF5Mk3D5x7A7Dj98cR84m", ex, new Object[0]));
        }
    }

    @ExceptionHandler({SQLException.class})
    public ResponseContainer<Void> handleSqlException(SQLException ex) {
        return this.handleApplicationException(SystemErrorEnum.SQL_EXCEPTION
                .wrapException("R46HdMuArr8a1ATva5ByRm", ex, new Object[0]));
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseContainer<Void> handleDataAccessException(DataAccessException ex) {
        return this.handleApplicationException(SystemErrorEnum.DATA_ACCESS_EXCEPTION
                .wrapException("7inoy4gsjmvXZD1A1BjS7o", ex, new Object[0]));
    }

    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseContainer<Void> handleDuplicateKeyException(DuplicateKeyException ex) {
        return this.handleApplicationException(BusinessErrorEnum
                .DUPLICATE_KEY.wrapException("5dscWd99k5kSZj52Lzyg6p", ex, new Object[0]));
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseContainer<Void> handleApplicationException(ApplicationException ex) {
        log.error("transactionId:{}, errCode:{}, type:{}, errorId:{}, message:{}. cause:{}",
                new Object[]{HeaderUtil.getTransactionId(), ex.getErrorCode(),
                        ex.getType(), ex.getErrorId(), ex.getMessage(),
                        ExceptionUtil.getStackTraces(ex)});
        return ResponseContainer.error(ex);
    }

    @ExceptionHandler({NestedServletException.class})
    public ResponseContainer<Void> handleNestedServletException(NestedServletException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof ApplicationException) {
            return this.handleApplicationException((ApplicationException)cause);
        } else {
            return cause instanceof DuplicateKeyException ?
                    this.handleDuplicateKeyException((DuplicateKeyException)cause) : this.handleException(cause);
        }
    }

    @ExceptionHandler({TypeMismatchException.class})
    public ResponseContainer<Void> typeMismatchHandler(TypeMismatchException exception) {
        String detailMsg = this.getMessage(TypeMismatchException.class,
                new String[]{Objects.toString(exception.getValue()), Objects.toString(exception.getRequiredType())});
        if (exception instanceof MethodArgumentTypeMismatchException) {
            detailMsg = this.getMessage((Exception)exception, new String[]{detailMsg});
        }

        return this.handleApplicationException(BusinessErrorEnum
                .ILLEGAL_PARAMETER.wrapException("WGYrdBvigGTLCenSNGvnTV", exception, new Object[]{detailMsg}));
    }

    @ExceptionHandler({BindException.class})
    public ResponseContainer<Void> bindExceptionHandler(BindException exception) {
        return this.buildValidResult(exception.getBindingResult(), exception);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseContainer<Void> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        return this.buildValidResult(exception.getBindingResult(), exception);
    }

    private ResponseContainer<Void> buildValidResult(BindingResult bindingResult, Exception e) {
        StringBuilder detailMsg = new StringBuilder();

        for(int i = 0; i < bindingResult.getFieldErrors().size(); ++i) {
            if (i > 0) {
                detailMsg.append(";");
            }

            FieldError error = bindingResult.getFieldErrors().get(i);
            String defaultMessage = error.getDefaultMessage();
            String msg = this.getMessage(defaultMessage, new Object[0], defaultMessage);
            detailMsg.append(msg);
        }

        String errorMessage = detailMsg.toString();
        return this.handleApplicationException(BusinessErrorEnum.ILLEGAL_PARAMETER.wrapException("5SxFgVgQG5mVPPEuCxWF63", e, new Object[]{errorMessage}));
    }

    @ExceptionHandler({HttpMessageConversionException.class})
    public ResponseContainer<Void> httpMessageConversionHandler(HttpMessageConversionException exception) {
        String detailMsg = this.getMessage(HttpMessageConversionException.class, new String[0]);
        return this.handleApplicationException(BusinessErrorEnum.ILLEGAL_PARAMETER.wrapException("Xe79MrpWEu47dD288YWX7Y", exception, new Object[]{detailMsg}));
    }

    @ExceptionHandler({ServletRequestBindingException.class})
    public ResponseContainer<Void> httpServletRequestBindingException(ServletRequestBindingException exception) {
        String detailMsg = this.getMessage(ServletRequestBindingException.class, new String[0]);
        return this.handleApplicationException(BusinessErrorEnum.ILLEGAL_PARAMETER.wrapException("Xe79MrpWEu47dD288YWX7Y", exception, new Object[]{detailMsg}));
    }
}
