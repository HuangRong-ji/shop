package com.shop.dao.impl;

import com.shop.bean.Order;
import com.shop.dao.BaseDao;
import com.shop.dao.OrderDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `t_order`(`order_id`,`create_time`,`price`,`status`,`user_id`)VALUES(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
