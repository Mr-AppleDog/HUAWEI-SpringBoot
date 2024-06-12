package com.huawei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    /*
    地址编号
     */
    private Integer addressId;

    /*
    收获人名称
     */
    private String addressName;

    /*
    收货人手机号
     */
    private String addressPhone;

    /*
    收货人地址
     */
    private String addressPlace;

    /*
    所属用户
     */
    private int addressUserUid;
}
