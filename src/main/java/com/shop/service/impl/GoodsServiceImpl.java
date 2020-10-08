package com.shop.service.impl;

import com.shop.bean.Goods;
import com.shop.bean.Page;
import com.shop.dao.GoodsDao;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int deleteGoodsById(Integer id) {
        return goodsDao.deleteGoodsById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public Goods queryGoodsById(Integer id) {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public List<Goods> queryGoods() {
        return goodsDao.queryGoods();
    }

    @Override
    public Page<Goods> page(int pageNo, int pageSize) {
//        System.out.println("GoodsServler" + pageNo);
//        System.out.println("GoodsServler" + pageSize);
        Page<Goods> page = new Page<Goods>();
//        System.out.println("goods"+pageNo);
        //每个页面的数量
        page.setPageSize(pageSize);
//        System.out.println("goods"+pageSize);
        //总记录数
        Integer pageTotalCount = goodsDao.queryForPageTotalCount();
//        System.out.println("Goods" + pageTotalCount);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
//        System.out.println("Goods" + pageTotal);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;

        List<Goods> items = goodsDao.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }
}
