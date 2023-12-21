package org.example.food.truck.util;


import org.example.food.truck.vo.HttpHeaderContext;

/**
 * HeaderUtil
 *
 * @author chensheng
 **/
public interface HeaderUtil {
    /**
     * 获得事务id
     *
     * @return x-transaction-id
     */
    static String getTransactionId() {
        return HttpHeaderContext.getPassThruHeaderMap().get("x-transaction-id");
    }
}
