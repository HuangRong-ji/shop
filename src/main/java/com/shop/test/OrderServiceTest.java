package com.shop.test;

import com.shop.bean.CartItem;
import com.shop.service.Cart;
import com.shop.service.OrderService;
import com.shop.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java�����ŵ���ͨ", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java�����ŵ���ͨ", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "���ݽṹ���㷨", 1, new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println( "�������ǣ�" + orderService.createOrder(cart, 1) );

    }
}
