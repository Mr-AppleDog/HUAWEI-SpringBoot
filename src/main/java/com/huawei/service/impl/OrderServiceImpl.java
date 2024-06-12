package com.huawei.service.impl;

import com.huawei.pojo.Order;
import com.huawei.pojo.OrderVO;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderServiceImpl {
    /**
     * 查询所有订单
     * @return
     */
    List<OrderVO> selectAllOrder(Order order);

    /**
     * 根据orderId查订单
     * @param orderId
     * @return
     */
    Order selectOneOrder(String orderId);

    /**
     * 根据id删除订单
     * @param orderId
     * @return
     */
    int deleteOrder(String orderId);

    /**
     * 更新订单
     * @param order
     * @return
     */
    int updateOrder(Order order);

    /**
     * 插入订单
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 插入订单
     * @param orderVO
     * @return
     */
    int insertOrder(OrderVO orderVO);
}
