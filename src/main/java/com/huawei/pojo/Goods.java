package com.huawei.pojo;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer goodsId;

    private String goodsName;

    private Integer goodsPrice;

    private Integer goodsStock;

    private List<Order> order;

}
