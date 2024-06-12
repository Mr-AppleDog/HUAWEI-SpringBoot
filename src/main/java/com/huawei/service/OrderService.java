package com.huawei.service;

import com.huawei.mapper.GoodsMapper;
import com.huawei.mapper.OrderItemMapper;
import com.huawei.mapper.OrderMapper;
import com.huawei.pojo.Goods;
import com.huawei.pojo.Order;
import com.huawei.pojo.OrderItem;
import com.huawei.pojo.OrderVO;
import com.huawei.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceImpl {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<OrderVO> selectAllOrder(Order order) {
        return orderMapper.selectAllOrder(order);
    }

    @Override
    public Order selectOneOrder(String orderId) {
        return orderMapper.selectOneOrder(orderId);
    }

    @Override
    public int deleteOrder(String orderId) {
        return orderMapper.deleteOrder(orderId);
    }

    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public int insertOrder(OrderVO orderVO) {
        //订单
        Order order=new Order();
        order.setOrderId(orderVO.getOrderId());
        order.setOrderDate(orderVO.getOrderDate());
        order.setOrderUserUid(orderVO.getUid());
        order.setOrderPrice(orderVO.getOrderItemPrice()*orderVO.getOrderItemNumber());
        System.out.println(order);
        //订单项
        OrderItem orderItem=new OrderItem();
        orderItem.setOrderItemOrderId(orderVO.getOrderId());
        orderItem.setOrderItemNumber(orderVO.getOrderItemNumber());
        orderItem.setOrderItemPrice(orderVO.getOrderItemPrice());
        orderItem.setOrderItemGoodsId(orderVO.getOrderItemGoodsId());
        System.out.println(orderItem);
        //商品

        //根据商品id查询商品
        Goods goods = goodsMapper.selectOneGoods(orderVO.getOrderItemGoodsId());

        //设置新的库存量
        goods.setGoodsStock(goods.getGoodsStock()-orderVO.getOrderItemNumber());
        //修改
        goodsMapper.updateGoods(goods);
        //插入
        int i = orderMapper.insertOrder(order);
        int i1 = orderItemMapper.insertOrderItem(orderItem);
        //修改库存
        return i;
    }
}
