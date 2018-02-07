<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="utf-8">
<title>用户管理</title>
<script type="text/javascript" src="static/js/angularjs-1.2.3-min.js"></script>
<script type="text/javascript" src="static/js/user/user.js"></script>

</head>
<body>
   <div data-ng-app="userApp" data-ng-controller="userCtrl">
   		<ul>
   			<li data-ng-repeat="user in userlist">
   				{{user.userName}}
   			</li>
   		</ul>
   </div>
</body>
</html>