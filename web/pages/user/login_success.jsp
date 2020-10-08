<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上商城会员注册页面</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <%--    <div>--%>
    <%--        <span>欢迎<span class="um_span">用户</span>光临网上商城</span>--%>
    <%--        <a href="pages/order/order.html">我的订单</a>--%>
    <%--        <a href="index2.jsp">注销</a>&nbsp;&nbsp;--%>
    <%--        <a href="index2.jsp">返回</a>--%>
    <%--    </div>--%>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <h1>欢迎回来 <a href="client/GoodsServlet?action=page">转到主页</a></h1>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
