package com.huawei.service.impl;


import com.huawei.pojo.Address;

import java.util.List;

public interface AddressServiceImpl {
    /**
     * 查询用户的所有地址
     * @param uid
     * @return
     */
    List<Address> selectAllByUid(Integer uid);

    /**
     * 根据addressId查询地址
     * @param addressId
     * @return
     */
    Address selectOneBuAddressId(int addressId);

    /**
     * 更新地址
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 根据addressId删除地址
     * @param addressId
     * @return
     */
    int deleteAddress(int addressId);

    /**
     * 插入地址
     * @param address
     * @return
     */
    int insertAddress(Address address);
}
