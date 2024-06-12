package com.huawei.mapper;

import com.huawei.pojo.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderItemTest {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Test
    public void select(){
        List<OrderItem> orderItems = orderItemMapper.selectAllOrderItem("1");
        System.out.println(orderItems);
    }
}
