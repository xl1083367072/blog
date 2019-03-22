<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">  
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0"> 
<title>${pageTitle }-SSM整合进阶之个人博客系统</title>

<link rel="stylesheet" href="${ctx}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${ctx}/static/css/blog.css">
<link href="http://blog.java1234.com/favicon.ico" rel="SHORTCUT ICON">
<script src="${ctx}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${ctx}/static/bootstrap3/js/bootstrap.min.js"></script>

<!-- 异步加载hm.js,类似<script src=""></script>这样加载的js，它的好处是异步的，不影响当前界面的渲染 -->
<script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?aa5c701f4f646931bf78b6f40b234ef5";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
</script>

<style type="text/css">
	  body {
        padding-top: 10px;
        padding-bottom: 40px;
      }
</style>
</head>
<body>
<div class="container">
	<jsp:include page="/foreground/common/head.jsp"/>
	<jsp:include page="/foreground/common/menu.jsp"/>
	
	<div class="row">
		<div class="col-md-9">
			<span style="color: red">错误信息:</span> ${errorInfo } <br/><br/><br/>
			<span style="font-size: 16px"><a href="${ctx }/index.html">点击这里返回首页</a></span>
		</div>
	</div>
	
</div>
</body>
</html>