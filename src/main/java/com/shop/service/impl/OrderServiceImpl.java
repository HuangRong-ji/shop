package com.shop.service.impl;

import com.shop.bean.CartItem;
import com.shop.bean.Goods;
import com.shop.bean.Order;
import com.shop.bean.OrderItem;
import com.shop.dao.GoodsDao;
import com.shop.dao.OrderDao;
import com.shop.dao.OrderItemDao;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.dao.impl.OrderDaoImpl;
import com.shop.dao.impl.OrderItemDaoImpl;
import com.shop.service.Cart;
import com.shop.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry : cart.getItemMap().entrySet()) {
            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);

            orderItemDao.saveOrderItem(orderItem);


            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Goods goods= goodsDao.queryGoodsById(cartItem.getId());
            goods.setSales( goods.getSales() + cartItem.getCount() );
            goods.setStock( goods.getStock() - cartItem.getCount() );
            goodsDao.updateGoods(goods);

        }
        cart.clear();
        return orderId;
    }
}
