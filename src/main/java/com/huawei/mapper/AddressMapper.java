package com.huawei.mapper;

import com.huawei.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    /**
     * 查询个人用户所有
     * @return
     */
    List<Address> selectAllByUid(Integer uid);

    /**
     * 根据id查地址
     * @param addressId
     * @return
     */
    Address selectOne(int addressId);

    /**
     * 跟新地址
     * @param address
     * @return
     */
    int updateAddress(Address address);

    /**
     * 根据id删除地址
     * @param addressId
     * @return
     */
    int deleteAddress(int addressId);

    /**
     * 添加地址
     * @param address
     * @return
     */
    int insertAddress(Address address);
}
