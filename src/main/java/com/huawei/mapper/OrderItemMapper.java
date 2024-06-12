package com.huawei.mapper;

import com.huawei.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    /**
     * 插入订单项
     * @param orderItem
     * @return
     */
    int insertOrderItem(OrderItem orderItem);

    /**
     * 根据订单id删除所有订单项
     * @param orderItemOrderId
     * @return
     */
    int deleteOrderItem(String orderItemOrderId);

    List<OrderItem> selectAllOrderItem(String orderItemOrderId);
}
