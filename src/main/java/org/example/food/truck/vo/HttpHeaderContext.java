package org.example.food.truck.vo;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * HttpHeaderContext
 *
 * @author chensheng
 **/
public class HttpHeaderContext {
    private static final TransmittableThreadLocal<Map<String, String>> PASS_THRU_HEADERS =
            new TransmittableThreadLocal<Map<String, String>>() {
        protected Map<String, String> initialValue() {
            return new HashMap(16);
        }
    };

    private HttpHeaderContext() {
    }

    public static Map<String, String> getPassThruHeaderMap() {
        return (Map) PASS_THRU_HEADERS.get();
    }

    public static void clear() {
        PASS_THRU_HEADERS.remove();
    }
}
