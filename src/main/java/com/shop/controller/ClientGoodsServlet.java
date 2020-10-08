package com.shop.controller;

import com.shop.bean.Goods;
import com.shop.bean.Page;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;
import com.shop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientGoodsServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        page(req, resp);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);


        Page<Goods> page =goodsService.page(pageNo,pageSize);

//        System.out.println(page);
        page.setUrl("client/GoodsServlet?action=page");
        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
