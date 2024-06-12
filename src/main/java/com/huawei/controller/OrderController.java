package com.huawei.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.mapper.OrderMapper;
import com.huawei.pojo.Order;
import com.huawei.pojo.OrderVO;
import com.huawei.service.OrderService;
import com.huawei.utils.AjaxResult;
import com.huawei.utils.CryptoUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huawei")
public class OrderController extends BaseController{
    @Autowired
    private OrderService orderService;

    @GetMapping("/admin/order")
    public AjaxResult selectAllOrder(@RequestParam("pageNumber") int pageNumber,
                                    @RequestParam("pageSize") int pageSize,
                                        Order order){
        PageHelper.startPage(pageNumber,pageSize);
        List<OrderVO> orders = orderService.selectAllOrder(order);
        PageInfo<OrderVO> orderPageInfo = new PageInfo<>(orders);
        return AjaxResult.success(orderPageInfo);
    }

    @GetMapping("/admin/order/{orderId}")
    public AjaxResult selectOne(@PathVariable("orderId") String orderId){
        Order order = orderService.selectOneOrder(orderId);
        return AjaxResult.success(order);
    }

    @PostMapping("/admin/order")
    public AjaxResult insert(@RequestBody Order order){
        return toAjax(orderService.insertOrder(order));
    }

    @DeleteMapping("/admin/order/{orderId}")
    public AjaxResult delete(@PathVariable("orderId") String orderId){
        return toAjax(orderService.deleteOrder(orderId));
    }

    @PostMapping("/user/order")
    public AjaxResult insertOrder(@RequestHeader("Token") String token,@RequestBody OrderVO orderVO){
        Integer integer = CryptoUtils.decryptByUid(token);
        orderVO.setUid(integer);
        return toAjax( orderService.insertOrder(orderVO));
    }
    @GetMapping("/user/order")
    public AjaxResult selectOrder(@RequestHeader("Token") String token){
        Integer integer = CryptoUtils.decryptByUid(token);
        Order order=new Order();
        order.setOrderUserUid(integer);
        List<OrderVO> orderVOS = orderService.selectAllOrder(order);
        return AjaxResult.success(orderVOS);
    }

}
