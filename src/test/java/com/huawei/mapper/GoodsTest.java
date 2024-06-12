package com.huawei.mapper;

import com.huawei.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsTest {

    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    public void insert(){
        Goods goods = new Goods(null,"pad",1888,200,null);
        int i = goodsMapper.insertGoods(goods);
        System.out.println(i);
    }

    @Test
    public void select(){
        Goods goods1 = new Goods();
        goods1.setGoodsName("手机");
        goods1.setGoodsPrice(9999);
        List<Goods> goods = goodsMapper.selectAllGoods(goods1);
        System.out.println(goods);
    }
    @Test
    public void update(){
        Goods goods=new Goods(1,"手机",9999,9998,null);
        int i = goodsMapper.updateGoods(goods);
        System.out.println(i);
    }
}
