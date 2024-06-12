package com.huawei.service.impl;

import com.huawei.pojo.OrderItem;

import java.util.List;

public interface OrderItemServiceImpl {
    /**
     * 插入订单项
     * @param orderItem
     * @return
     */
    int insertOrderItem(OrderItem orderItem);

    /**
     * 根据订单id删除订单项
     * @param orderId
     * @return
     */
    int deleteOrderItem(String orderId);


    /**
     * 根据订单id查询所有订单项
     * @param orderId
     * @return
     */
    List<OrderItem> selectAllOrderItem(String orderId);

}
