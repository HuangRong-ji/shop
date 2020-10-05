<html>
	<head>
		<meta charset="UTF-8">
		<title>订单管理</title>
		<base href="http://localhost:8080/shop/"/>
		<link type="text/css" rel="stylesheet" href="static/css/style.css">
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<script src="static/js/jquery-1.11.3.min.js"></script>
		<script src="static/js/bootstrap.js"></script>
	</head>
	<body>

		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">订单管理系统</span>
			<div>
				<a href="pages/manager/shop_manager.html">商品管理</a>
				<a href="pages/manager/order_manager.html">订单管理</a>
				<a href="index.html">返回商城</a>
			</div>
		</div>

		<div id="main">
			<table>
				<tr>
					<td>日期</td>
					<td>金额</td>
					<td>详情</td>
					<td>发货</td>

				</tr>
				<tr>
					<td>2020.04.23</td>
					<td>90.00</td>
					<td><a href="#">查看详情</a></td>
					<td><a href="#">点击发货</a></td>
				</tr>

				<tr>
					<td>2020.04.20</td>
					<td>20.00</td>
					<td><a href="#">查看详情</a></td>
					<td>已发货</td>
				</tr>

				<tr>
					<td>2014.01.23</td>
					<td>190.00</td>
					<td><a href="#">查看详情</a></td>
					<td>等待收货</td>
				</tr>
			</table>
		</div>

		<div id="bottom">
			<span>
				网上商城.Copyright &copy;2020
			</span>
		</div>
	</body>
</html>
