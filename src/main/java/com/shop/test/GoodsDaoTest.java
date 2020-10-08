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
//        System.out.println(goodsDao.addGoods(new Goods(null, "小米手机", new
//                BigDecimal(9999), "小米", 1100000, 0, null)));

//        System.out.println(goodsDao.deleteGoodsById(1));
//        System.out.println(goodsDao.updateGoods(new Goods(2, "小米手机", new
//                BigDecimal(9999), "小爱", 1100000, 0, null)));

//        System.out.println(goodsDao.queryGoodsById(2));
        System.out.println(goodsDao.queryGoods());
        System.out.println(goodsDao.queryForPageTotalCount());
    }

}
