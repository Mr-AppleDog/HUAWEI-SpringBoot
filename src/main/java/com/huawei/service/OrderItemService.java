package com.huawei.service;

import com.huawei.mapper.OrderItemMapper;
import com.huawei.pojo.OrderItem;
import com.huawei.service.impl.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService implements OrderItemServiceImpl {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public int insertOrderItem(OrderItem orderItem) {
        return orderItemMapper.insertOrderItem(orderItem);
    }

    @Override
    public int deleteOrderItem(String orderId) {
        return orderItemMapper.deleteOrderItem(orderId);
    }

    @Override
    public List<OrderItem> selectAllOrderItem(String orderId) {
        return orderItemMapper.selectAllOrderItem(orderId);
    }
}
