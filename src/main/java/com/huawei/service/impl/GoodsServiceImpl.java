package com.huawei.service.impl;

import com.huawei.pojo.Goods;

import java.util.List;

public interface GoodsServiceImpl {
    /**
     * 查询所有商品
     * @return
     */
    List<Goods> selectAllGoods(Goods goods);

    /**
     * 根据goodsID查单个
     * @param goodsId
     * @return
     */
    Goods selectOne(int goodsId);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 删除商品
     * @param goodsId
     * @return
     */
    int deleteGoods(int goodsId);

    /**
     * 插入商品
     * @param goods
     * @return
     */
    int insertGoods(Goods goods);
}
