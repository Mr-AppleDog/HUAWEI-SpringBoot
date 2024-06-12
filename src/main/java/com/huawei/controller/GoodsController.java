package com.huawei.controller;

import com.huawei.pojo.Goods;
import com.huawei.service.GoodsService;
import com.huawei.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huawei")
public class GoodsController extends BaseController{

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public AjaxResult select(Goods goods){
        List<Goods> goods1 = goodsService.selectAllGoods(goods);
        return AjaxResult.success(goods1);
    }

    @GetMapping("/goods/{goodId}")
    public AjaxResult selectOne(@PathVariable("goodId") int goodId){
        Goods goods = goodsService.selectOne(goodId);
        return AjaxResult.success(goods);
    }

    @PostMapping("/goods")
    public AjaxResult insert(@RequestBody Goods goods){
        return toAjax(goodsService.insertGoods(goods));
    }


    @PutMapping("/goods")
    public AjaxResult update(@RequestBody Goods goods){
        return toAjax(goodsService.updateGoods(goods));
    }

    @DeleteMapping("/goods/{goodsId}")
    public AjaxResult delete(@PathVariable("goodsId") int goodsId){
        return toAjax(goodsService.deleteGoods(goodsId));
    }

}
