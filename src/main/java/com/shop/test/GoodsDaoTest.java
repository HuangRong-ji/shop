package com.shop.test;

import com.shop.bean.Goods;
import com.shop.dao.GoodsDao;
import com.shop.dao.impl.GoodsDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class GoodsDaoTest {
    GoodsDao goodsDao = new GoodsDaoImpl();

    @Test
    public void test() {
//        System.out.println(goodsDao.addGoods(new Goods(null, "С���ֻ�", new
//                BigDecimal(9999), "С��", 1100000, 0, null)));

//        System.out.println(goodsDao.deleteGoodsById(1));
//        System.out.println(goodsDao.updateGoods(new Goods(2, "С���ֻ�", new
//                BigDecimal(9999), "С��", 1100000, 0, null)));

//        System.out.println(goodsDao.queryGoodsById(2));
        System.out.println(goodsDao.queryGoods());
        System.out.println(goodsDao.queryForPageTotalCount());
    }

}
