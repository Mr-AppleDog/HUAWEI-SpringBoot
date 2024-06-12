package com.huawei.mapper;

import com.huawei.pojo.Goods;

import java.util.List;

public interface GoodsMapper {
    /**
     * 查询所有商品
     * @return
     */
    List<Goods> selectAllGoods(Goods goods);

    /**
     * 条件查询
     * @return
     */
    Goods selectOneGoods(int goodsId);


    /**
     * 修改商品
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 根据id删除商品
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
