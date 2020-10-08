package com.shop.controller;

import com.shop.bean.CartItem;
import com.shop.bean.Goods;
import com.shop.service.Cart;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;
import com.shop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    GoodsService goodsService = new GoodsServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CartServlet的addItem");
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println("CartServlet的" + id);
        Goods goods = goodsService.queryGoodsById(id);

        CartItem cartItem = new CartItem(goods.getId(), goods.getName(), 1, goods.getPrice(), goods.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastName", cartItem.getName());

        System.out.println("请求头Referer的值" + req.getHeader("Referer"));

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("id"));
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        System.out.println("deleteItem的id"+id);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

}
