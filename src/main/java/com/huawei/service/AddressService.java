package com.huawei.service;

import com.huawei.mapper.AddressMapper;
import com.huawei.pojo.Address;
import com.huawei.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService implements AddressServiceImpl {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> selectAllByUid(Integer uid) {
        return addressMapper.selectAllByUid(uid);
    }

    @Override
    public Address selectOneBuAddressId(int addressId) {
        return addressMapper.selectOne(addressId);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int deleteAddress(int addressId) {
        return addressMapper.deleteAddress(addressId);
    }

    @Override
    public int insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }
}
