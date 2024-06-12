package com.huawei.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    /*
    订单编号
     */
    private String orderId;

    /*
    订单价格
     */
    private String orderPrice;

    /*
    订单时间
     */
    private String orderDate;

    /*
    用户id
     */
    private Integer uid;


    /*
        用户名称
         */
    private String userName;


    /*
    商品项id
     */
    private int orderItemGoodsId;

    /*
    商品项数量
     */
    private int orderItemNumber;

    /*
    商品项价格
     */
    private int orderItemPrice;

    /*
    商品名称
     */
    private String goodsName;


    /*
    图片
     */
    private String img;

}
