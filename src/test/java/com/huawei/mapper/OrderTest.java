package com.huawei.mapper;

import com.huawei.pojo.Order;
import com.huawei.pojo.OrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void select(){
        Order order=new Order();
        order.setOrderId("2");
        List<OrderVO> orders = orderMapper.selectAllOrder(order);
        System.out.println(orders);
    }
    @Test
    public void insert(){
        Order order = new Order();
        order.setOrderId("6");
        order.setOrderDate("2023-09-21");
        order.setOrderPrice(999);
        order.setOrderUserUid(2);
        int i = orderMapper.insertOrder(order);
        System.out.println(i);
    }
    @Test
    public void delete(){
        int i = orderMapper.deleteOrder("6");
        System.out.println(i);
    }
}
