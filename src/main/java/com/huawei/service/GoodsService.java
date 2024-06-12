package com.huawei.service;

import com.huawei.mapper.GoodsMapper;
import com.huawei.pojo.Goods;
import com.huawei.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements GoodsServiceImpl {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> selectAllGoods(Goods goods) {
        return goodsMapper.selectAllGoods(goods);
    }

    @Override
    public Goods selectOne(int goodsId) {
        return goodsMapper.selectOneGoods(goodsId);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoods(int goodsId) {
        return goodsMapper.deleteGoods(goodsId);
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }
}
