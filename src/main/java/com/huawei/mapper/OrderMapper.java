package com.huawei.mapper;

import com.huawei.pojo.Order;
import com.huawei.pojo.OrderVO;
import com.huawei.pojo.User;

import java.util.List;

public interface OrderMapper {
    /**
     * 查询所有订单
     * @return
     */
    List<OrderVO> selectAllOrder(Order order);

    /**
     * 根据orderID查订单
     * @param orderId
     * @return
     */
    Order selectOneOrder(String orderId);

    /**
     * 根据orderId删除订单
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
}
