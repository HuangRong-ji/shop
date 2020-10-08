<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城首页</title>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="static/js/jquery-1.11.3.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button.addToCart").click(function () {
                var goodsId = $(this).attr("goodsId");
                location.href = "./CartServlet?action=addItem&id=" + goodsId;
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上商城</span>
    <div>
        <a href="pages/user/login.jsp" class="btn btn-lg btn-info">登录</a> |
        <a href="pages/user/regist.jsp" class="btn btn-lg btn-info">注册</a> &nbsp;&nbsp;
        <a href="pages/cart/cart.jsp" class="btn btn-lg btn-info">购物车</a>
        <a href="pages/manager/manager.jsp" class="btn btn-lg btn-info">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="shop">
        <div class="shop_cond">
            <form action="" method="get">
                价格：<input id="min" type="text" name="min" value=""> 元 -
                <input id="max" type="text" name="max" value=""> 元
                <button type="submit" class="btn btn-group-lg btn-primary">查询</button>
            </form>
        </div>
<%--        <div style="text-align: center">--%>
<%--            <c:if test="${empty sessionScope.cart.items}">--%>
<%--                &lt;%&ndash;购物车为空的输出&ndash;%&gt;--%>
<%--                <span> </span>--%>
<%--                <div>--%>
<%--                    <span style="color: red">当前购物车为空</span>--%>
<%--                </div>--%>
<%--            </c:if>--%>
<%--            <c:if test="${not empty sessionScope.cart.items}">--%>
<%--                &lt;%&ndash;购物车非空的输出&ndash;%&gt;--%>
<%--                <span>您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>--%>
<%--                <div>--%>
<%--                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中--%>
<%--                </div>--%>
<%--            </c:if>--%>
<%--        </div>--%>
        <div class="b_list">
            <div class="img_div">
                <img class="shop_img" alt="" src="static/img/default.jpg"/>
            </div>
            <div class="shop_info">
                <div class="shop_name">
                    <span class="sp1">商品名:</span>
                    <span class="sp2">滚筒洗衣机</span>
                </div>
                <div class="shop_author">
                    <span class="sp1">品牌:</span>
                    <span class="sp2">奥利给</span>
                </div>
                <div class="shop_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥500.00</span>
                </div>
                <div class="shop_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">230</span>
                </div>
                <div class="shop_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">1000</span>
                </div>
                <div class="shop_add">
                    <button class="btn btn-sm btn-info addToCart">加入购物车</button>
                </div>
            </div>
        </div>

        <div class="b_list">
            <div class="img_div">
                <img class="shop_img" alt="" src="static/img/default.jpg"/>
            </div>
            <div class="shop_info">
                <div class="shop_name">
                    <span class="sp1">商品名:</span>
                    <span class="sp2">滚筒洗衣机</span>
                </div>
                <div class="shop_author">
                    <span class="sp1">品牌:</span>
                    <span class="sp2">奥利给</span>
                </div>
                <div class="shop_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥500.00</span>
                </div>
                <div class="shop_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">230</span>
                </div>
                <div class="shop_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">1000</span>
                </div>
                <div class="shop_add">
                    <button class="btn btn-sm btn-info addToCart">加入购物车</button>
                </div>
            </div>
        </div>

        <div class="b_list">
            <div class="img_div">
                <img class="shop_img" alt="" src="static/img/default.jpg"/>
            </div>
            <div class="shop_info">
                <div class="shop_name">
                    <span class="sp1">商品名:</span>
                    <span class="sp2">滚筒洗衣机</span>
                    <div class="shop_author">
                    </div>
                    <span class="sp1">品牌:</span>
                    <span class="sp2">奥利给</span>
                </div>
                <div class="shop_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥500.00</span>
                </div>
                <div class="shop_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">230</span>
                </div>
                <div class="shop_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">1000</span>
                </div>
                <div class="shop_add">
                    <button class="btn btn-sm btn-info addToCart">加入购物车</button>
                </div>
            </div>
        </div>

        <div class="b_list">
            <div class="img_div">
                <img class="shop_img" alt="" src="static/img/default.jpg"/>
            </div>
            <div class="shop_info">
                <div class="shop_name">
                    <span class="sp1">商品名:</span>
                    <span class="sp2">滚筒洗衣机</span>
                </div>
                <div class="shop_author">
                    <span class="sp1">品牌:</span>
                    <span class="sp2">奥利给</span>
                </div>
                <div class="shop_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥500.00</span>
                </div>
                <div class="shop_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">230</span>
                </div>
                <div class="shop_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">1000</span>
                </div>
                <div class="shop_add">
                    <button class="btn btn-sm btn-info addToCart">加入购物车</button>
                </div>
            </div>
        </div>
    </div>

    <div id="page_nav">
        <a href="#">首页</a>
        <a href="#">上一页</a>
        <a href="#">3</a>
        【4】
        <a href="#">5</a>
        <a href="#">下一页</a>
        <a href="#">末页</a>
        共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页
        <button class="btn btn-sm btn-default">确定
        </button>
    </div>

</div>

<%@include file="pages/common/footer.jsp" %>
</body>
</html>
