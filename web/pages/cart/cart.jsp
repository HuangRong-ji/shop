<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？")

            })
            $("#clearCart").click(function () {
                return confirm("你确定要清空购物车吗?");
            })

            $(".updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr('goodsId');
                // 获取商品数量
                var count = this.value;
                if (confirm("你确定要将 【" + name + "】商品修改数量为：" + count + " 吗?")) {
                    //发起请求。给服务器保存修改
                    location.href =
                        "http://localhost:8080/shop/CartServlet?action=updateCount&count=" + count + "&id=" + id;
                } else {
                    // defaultValue 属性是表单项Dom 对象的属性。它表示默认的value 属性值。
                    this.value = this.defaultValue;
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.itemMap}">
            <tr>
                <td colspan="5">
                    <a href="index.jsp">
                        亲,当前购物车为空！快跟小伙伴去购物吧！
                    </a>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.itemMap}">
            <c:forEach items="${sessionScope.cart.itemMap}" var="entry">
                <tr>
                    <td>
                            ${entry.value.name}
                    </td>
                    <td>
                        <input class="updateCount" style="width: 80px" ;
                               goodsId="${entry.value.id}"
                               type="text" value="${entry.value.count}"/>
                    </td>
                    <td>
                            ${entry.value.price}
                    </td>
                    <td>
                            ${entry.value.totalPrice}
                    </td>
                    <td>
                        <a class="deleteItem" href="CartServlet?action=deleteItem&id=${entry.value.id}" >删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${not empty sessionScope.cart.itemMap}">
            <div class="cart_info">
                <span class="cart_span">
                    购物车共有<span class="b_count">${sessionScope.cart.totalCount}</span>
                件商品</span>
                <span class="cart_span">
                    总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>
                元</span>
                <span class="cart_span">
                    <a href="CartServlet?action=clear" id="clearCart">清空购物车</a>
                </span>
                <span class="cart_span">
                    <a href="OrderServlet?action=createOrder">去结账</a>
                </span>
            </div>
        </c:if>
    </table>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
