package com.shop.dao.impl;

import com.shop.bean.OrderItem;
import com.shop.dao.BaseDao;
import com.shop.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="INSERT INTO `t_order_item`(`id`,`name`,`count`,`price`,`total_price`,`order_id`)VALUES(?,?,?,?,?,?)";
        return update(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
