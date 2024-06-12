package com.huawei.controller;

import com.huawei.pojo.Address;
import com.huawei.service.AddressService;
import com.huawei.utils.AjaxResult;
import com.huawei.utils.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huawei")
public class AddressController extends BaseController{
    @Autowired
    private AddressService addressService;


    @GetMapping("/address")
    public AjaxResult selectAll(@RequestHeader(name="Token",required = false) String token,
                                @RequestParam(name="uid",required =false) Integer uid){

        Integer uidToken = CryptoUtils.decryptByUid(token);
        Integer id= uidToken!=null?uidToken:uid;
        //        int uid=1;//从cookie 中解析出
        List<Address> addresses = addressService.selectAllByUid(id);
        return AjaxResult.success(addresses);
    }


    @GetMapping("/address/{addressId}")
    public AjaxResult selectOne(@PathVariable("addressId") int addressId){
        Address address = addressService.selectOneBuAddressId(addressId);
        return AjaxResult.success(address);
    }

    @PostMapping("/address")
    public AjaxResult insertAddress(@RequestHeader(name = "Token" )String token,@RequestBody Address address){
        Integer userId = CryptoUtils.decryptByUid(token);
        System.out.println(userId);
        address.setAddressUserUid(userId);
        return toAjax(addressService.insertAddress(address));
    }

    @PutMapping("/address")
    public AjaxResult updateAddress(@RequestBody Address address){
        return toAjax(addressService.updateAddress(address));
    }

    @DeleteMapping("/address/{addressId}")
    public AjaxResult deleteAddress(@PathVariable("addressId") int addressID){
        return toAjax(addressService.deleteAddress(addressID));
    }
}
