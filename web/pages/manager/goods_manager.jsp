<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("你确认要删除[" + $(this).parent().parent().find("td:first").text() + "]?");
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">商品管理系统</span>
    <%--    <div>--%>
    <%--        <a href="manager/GoodsServlet?action=list">商品管理</a>--%>
    <%--        <a href="order_manager.jsp">订单管理</a>--%>
    <%--        <a href="index2.jsp">返回商城</a>--%>
    <%--    </div>--%>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>品牌</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="good">
            <tr>
                <td>${good.name}</td>
                <td>${good.price}</td>
                <td>${good.producer}</td>
                <td>${good.sales}</td>
                <td>${good.stock}</td>

                <td><a href="GoodsServlet?action=getGoods&id=${good.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="GoodsServlet?action=delete&id=${good.id}">删除</a></td>
            </tr>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <%--            <td><a href="/shop/pages/manager/goods_edit.jsp">添加商品</a></td>--%>
            <td><a href="./pages/manager/goods_edit.jsp">添加商品</a></td>
        </tr>
    </table>
    <%--    分页代码--%>
    <%@include file="/pages/common/page_nav.jsp" %>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
