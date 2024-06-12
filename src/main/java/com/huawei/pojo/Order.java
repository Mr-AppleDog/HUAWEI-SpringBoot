package com.huawei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;

    private int orderPrice;

    private String orderDate;

    private Integer orderUserUid;

    private List<OrderItem> item;
}
