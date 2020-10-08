<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上商城会员登录页面</title>

    <%@include file="/pages/common/head.jsp" %>

    <%--    <script type="text/javascript">--%>
    <%--        $(function () {--%>
    <%--            $("#code_img").click(function () {--%>
    <%--                // 在事件响应的function 函数中有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象--%>
    <%--                // src 属性表示验证码 img 标签的 图片路径。它可读，可写--%>
    <%--                // alert(this.src);--%>
    <%--                this.src = "${basePath}kaptcha.jpg?d=" + new Date();--%>
    <%--            });--%>
    <%--        })--%>

    <%--        function fun(obj) {--%>
    <%--            alert(this.src);--%>

    <%--            $(obj).src = "${basePath}kaptcha.jpg?d=" + new Date();--%>
    <%--        }--%>

    <%--    </script>--%>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>网上商城会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">请输入用户名和密码</span>
                </div>
                <div class="form">
                    <form action="UserServlet" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        验证码：<input type="text" style="width: 80px;" name="code">
                        <img src="kaptcha.jpg" alt="" style="width: 100px; height: 28px;" id="code_img"
                             onclick="this.src='kaptcha.jpg'">
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</div>
</body>
</html>
