<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
var basePath = "<%=basePath%>";
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=basePath%>/js/jquery-1.11.2.min.js">
	
</script>
<script type="text/javascript"
	src="<%=basePath%>/js/login.js?<%=Math.random()%>>">
	
</script>
</head>
<body>
	<h1>登陆页面</h1>

	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" id="userName"></td>
		</tr>
		<tr>
			<td>密 码:</td>
			<td><input type="text" id="password"></td>
		</tr>
		<tr>
			<td><input type="button" value="注册" id="registBtn"></td>
			<td><input type="button" value="提交" id="loginBtn"></td>
		</tr>
	</table>
	<div id="message"></div>


	<div id="register" style="display:none;margin-top:150px;">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" id="r_userName"></td>
			</tr>
			<tr>
				<td>密 码:</td>
				<td><input type="text" id="r_password"></td>
			</tr>
			<tr>
				<td>昵 称:</td>
				<td><input type="text" id="r_nickName"></td>
			</tr>
			<tr>
				<td>性 别:</td>
				<td><select id="r_gender">
						<option value="Male">男</option>
						<option value="Female">女</option>
				</select>
			</tr>
			<tr>
				<td>居住地址:</td>
				<td><input type="text" id="r_address"></td>
			</tr>
			<tr>
				<td>国 籍:</td>
				<td><select id="r_nation">
						<option value="China">中国</option>
						<option value="America">美国</option>
						<option value="Japan">日本</option>
						<option value="Korea">韩国</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="button" value="提交注册" id="registSubmitBtn"></td>
			</tr>

		</table>
		<div id="registe_message" ></div>
	</div>
</body>
</html>