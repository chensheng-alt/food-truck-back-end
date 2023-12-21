package org.example.food.truck.core.util;

import lombok.extern.slf4j.Slf4j;
import org.example.food.truck.config.ApplicationContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * MessageUtil
 *
 * @author chensheng
 **/
@Slf4j
public class MessageUtil {
    private static volatile MessageSource messageSource = null;

    private MessageUtil() {
    }

    public static String getMessage(String key, Object[] args, String defaultValue) {
        MessageSource messageSource = getMessageSource();
        if (messageSource != null) {
            Locale locale = LocaleContextHolder.getLocale();
            log.trace("getMessage key: {}, default value: {}, locale: {}", new Object[]{key, defaultValue, locale});

            try {
                return messageSource.getMessage(key, args, locale);
            } catch (NoSuchMessageException var6) {
                log.debug("Key {} not found.", key);
            }
        }

        return defaultValue;
    }

    public static MessageSource getMessageSource() {
        if (messageSource == null) {
            synchronized(MessageUtil.class) {
                if (messageSource == null) {
                    try {
                        messageSource = ApplicationContextHolder.getBean(MessageSource.class);
                    } catch (Exception var3) {
                        log.error("Failed to get message source", var3);
                    }
                }
            }
        }

        return messageSource;
    }
}
