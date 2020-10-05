<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上商城会员注册页面</title>

    <%@include file="/pages/common/head.jsp" %>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                // 验证用户名： 必须由字母， 数字下划线组成， 并且长度为 5 到 12 位
                // 1.获取用户名输入框中的内容
                var usernameText = $("#username").val();
                //2.创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!usernamePatt.test(usernameText)){
                    //提示用户结果
                    $(".errorMsg").text("用户名不合法！");
                    return false;
                }
                //验证密码 必须由字母， 数字下划线组成， 并且长度为 5 到 12 位
                // 1.获取用户名输入框中的内容
                var passwordText = $("#password").val();
                //2.创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!passwordPatt.test(passwordText)){
                    //提示用户结果
                    $(".errorMsg").text("密码不合法！");
                    return false;
                }

                //验证确认密码 和密码相同
                //1.获取确认密码内容
                var repwdText = $("#repwd").val();
                //2.和密码相比较
                if (repwdText != passwordText){
                    $(".errorMsg").text("两次输入的密码不一致！");
                    return false;
                }

                //邮箱验证
                //1.获取邮箱内容
                var emailText = $("#email").val();
                //2.创建正则表达式对象
                var emailPatt = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                //3.使用test方法验证
                if (!emailPatt.test(emailText)){
                    $(".errorMsg").text("邮箱格式不合法！");
                    return false;
                }

                //验证码 目前只需要验证用户是否输入
                var codeText = $("#code").val();
                //去掉验证码前后空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText == ""){
                    //提示用户
                    $(".errorMsg").text("验证码不能为空！");
                    return false;
                }
                $(".errorMsg").text("");
            })
        })

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册网上商城会员</h1>
                    <span class="errorMsg"></span>
                </div>
                <div class="form">
                    <form action="UserServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code" name="code" />
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
