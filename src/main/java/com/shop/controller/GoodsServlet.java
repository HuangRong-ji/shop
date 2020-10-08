package com.shop.controller;

import com.shop.bean.Goods;
import com.shop.bean.Page;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;
import com.shop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends BaseServlet {
    GoodsService goodsService = new GoodsServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goods = goodsService.queryGoods();
        req.setAttribute("goods", goods);
        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = WebUtils.copyParamToBean(req.getParameterMap(), new Goods());
        goodsService.addGoods(goods);

        resp.sendRedirect("GoodsServlet?action=page");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        goodsService.deleteGoodsById(id);

        resp.sendRedirect("GoodsServlet?action=page");
    }

    protected void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Goods good = goodsService.queryGoodsById(id);

        req.setAttribute("good", good);

        req.getRequestDispatcher("pages/manager/goods_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = WebUtils.copyParamToBean(req.getParameterMap(), new Goods());
        goodsService.updateGoods(goods);

        resp.sendRedirect(req.getContextPath() + "/GoodsServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        System.out.println(pageNo);
//        System.out.println(pageSize);
//        Page<Goods> page = goodsService.page(1, 4);
        Page<Goods> page = goodsService.page(pageNo, pageSize);
//        System.out.println(page);
        page.setUrl("GoodsServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req, resp);
    }

}
