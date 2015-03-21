<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
var basePath = "<%=basePath%>";
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=basePath%>/js/jquery-1.11.2.min.js" > </script>
<script type="text/javascript" src="<%=basePath%>/js/login.js?<%=Math.random() %>>" > </script>
</head>
<body>
	<h1>登陆页面</h1>

	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" id="userName"></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="text" id="password"></td>
		</tr>
		<tr>
			<td><input type="button" value="注册"id="registBtn"></td>
			<td><input type="button" value="提交"id="loginBtn"></td>
		</tr>
	</table>
	<div id="message"></div>
<%-- 	<img alt="asd" src="<%=request.getContextPath() %>/img/123.jpg"> --%>

</body>
</html>