package com.huawei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private String orderItemOrderId;

    private int orderItemGoodsId;

    private int orderItemNumber;

    private int orderItemPrice;
}
